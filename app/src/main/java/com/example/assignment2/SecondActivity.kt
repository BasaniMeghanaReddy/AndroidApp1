package com.example.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // List of mobile software engineering challenges
        val challenges = listOf(
            "- Security Concerns",
            "- Data Synchronization",
            "- Performance Optimization",
            "- Platform Specific Development" ,
            "- Network Issues"
        )

        // Find the TextView and display challenges
        val challengesTextView = findViewById<TextView>(R.id.challengesTextView)
        challengesTextView.text = challenges.joinToString("\n")

        // Find button and set click listener to go back to MainActivity
        val mainActivityButton = findViewById<Button>(R.id.mainActivityButton)
        mainActivityButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
