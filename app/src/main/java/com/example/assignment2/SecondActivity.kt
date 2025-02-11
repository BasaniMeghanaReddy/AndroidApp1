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
            "- High battery consumption due to inefficient code or excessive background processing.",
            "- Slow app launch times affecting user experience.",
            "- Memory leaks causing app crashes or sluggish performance.",
            "- Inefficient API calls leading to network latency." ,
            "- Large app size due to unoptimized assets and libraries."
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
