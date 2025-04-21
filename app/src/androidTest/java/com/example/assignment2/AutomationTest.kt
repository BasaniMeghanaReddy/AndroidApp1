package com.example.assignment2

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleUiAutomatorTest {

    private lateinit var device: UiDevice
    private val PACKAGE = "com.example.assignment2"

    @Before
    fun setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
    }

    @Test
    fun testStartExplicitIntentAndCheckChallenge() {
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 5000)

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = context.packageManager.getLaunchIntentForPackage(PACKAGE)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        device.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), 5000)

        val explicitButton = device.findObject(By.res(PACKAGE, "explicitButton"))
        explicitButton.click()

        device.wait(Until.hasObject(By.res(PACKAGE, "challengesTextView")), 5000)

        val challengesTextView = device.findObject(By.res(PACKAGE, "challengesTextView"))
        assert(challengesTextView.text.contains("Security Concerns"))
    }
}
