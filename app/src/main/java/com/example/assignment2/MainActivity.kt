package com.example.assignment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Button for explicit intent
        val explicitButton = findViewById<Button>(R.id.explicitButton)
        explicitButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


        val implicitButton = findViewById<Button>(R.id.implicitButton)
        implicitButton.setOnClickListener {
            val intent = Intent("com.example.assignment2.IMPLICIT_ACTIVITY")
            startActivity(intent)
        }

        val viewImageButton = findViewById<Button>(R.id.viewImageButton)
        viewImageButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}