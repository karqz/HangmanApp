package com.example.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.hangman.models.GameResult
import com.example.hangman.models.Password
import java.util.*


class Game : AppCompatActivity() {
    private var password : Password? = null
    private var wrongAttempts = 0
    private var gameStarted = false
    private var solution : TextView? = null
    private var hangmanImage : ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        wrongAttempts = 0
        password = DBHelper(this).getRandomPassword()
        findViewById<TextView>(R.id.category).text = password?.category?.name


        solution = findViewById(R.id.hangmanSolution)
        hangmanImage = findViewById(R.id.hangmanImage)


        solution?.text = password?.word?.replace("[A-Z]".toRegex(), "_")
        hangmanImage?.setImageResource(R.drawable.hangman_0)

        setButtons()
    }

    private fun setButtons() {
        for (letter in 'A'..'Z') {
            val buttonId = resources.getIdentifier("letter$letter","id", packageName)
            val button = findViewById<Button>(buttonId)
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))

            button.setOnClickListener{
                gameStarted = true
                button.isClickable = false
                if (letter in password?.word!!) {
                    rightGuess(button, letter)
                }
                else {
                    wrongGuess(button)
                }
            }
        }
    }

    private fun rightGuess(button: Button, letter : Char) {
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        solution?.text = solution?.text.toString().mapIndexed { index, c ->
            if (letter == password?.word!![index]) {
                letter
            } else c
        }.joinToString("")

        if ('_' !in solution?.text!!) {
            DBHelper(this).addGame(GameResult(true, Date()))
            Result(this, R.drawable.win, R.string.win_info).show()
        }
    }

    private fun wrongGuess(button: Button) {
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        wrongAttempts += 1
        val imageId = resources.getIdentifier("hangman_$wrongAttempts","drawable", packageName)
        hangmanImage?.setImageResource(imageId)
        if (wrongAttempts == 9) {
            solution?.text = password?.word!!
            DBHelper(this).addGame(GameResult(false, Date()))
            Result(this, R.drawable.lose, R.string.lose_info).show()
        }
    }

    override fun onBackPressed() {
        if (!gameStarted) {
            super.onBackPressed()
        }
    }
}
