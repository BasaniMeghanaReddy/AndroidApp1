package com.example.assignment2

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CUSTOM_PERMISSION = "com.example.assignment2.MSE412"
    private val REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Request permission as per instructions
        if (ContextCompat.checkSelfPermission(this, CUSTOM_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(CUSTOM_PERMISSION), REQUEST_CODE)
        }

        val explicitButton = findViewById<Button>(R.id.explicitButton)
        val implicitButton = findViewById<Button>(R.id.implicitButton)
        val viewImageButton = findViewById<Button>(R.id.viewImageButton)

        explicitButton.setOnClickListener {
            if (hasPermission()) {
                startActivity(Intent(this, SecondActivity::class.java))
            } else {
                Toast.makeText(this, "Permission required to open challenges.", Toast.LENGTH_SHORT).show()
            }
        }

        implicitButton.setOnClickListener {
            if (hasPermission()) {
                val intent = Intent("com.example.assignment2.IMPLICIT_ACTIVITY")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Cannot proceed without permission.", Toast.LENGTH_SHORT).show()
            }
        }

        viewImageButton.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }

    private fun hasPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, CUSTOM_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Access granted to MSE challenges", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Access denied. You can't view MSE challenges.", Toast.LENGTH_LONG).show()
            }
            }
        }
}