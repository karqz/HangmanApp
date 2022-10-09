package com.example.hangman


import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button


class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val playButton = findViewById<Button>(R.id.playButton)
        val statisticsButton = findViewById<Button>(R.id.statisticsButton)

        playButton.setOnClickListener{
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        statisticsButton.setOnClickListener{
            val intent = Intent(this, Statistics::class.java)
            startActivity(intent)
        }
    }
}