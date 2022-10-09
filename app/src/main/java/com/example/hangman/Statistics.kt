package com.example.hangman

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class Statistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        val db = DBHelper(this)
        updateCounts(db)

        findViewById<Button>(R.id.menuButton).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.clearDataButton).setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setPositiveButtonText("Clear!").build()
            datePicker.addOnPositiveButtonClickListener {
                val from = Date(it.first)
                val cal = Calendar.getInstance()
                cal.time = Date(it.second)
                cal.add(Calendar.DATE, 1)
                val to = cal.time
                db.clearGameResults(from, to)
                updateCounts(db)
            }

            datePicker.show(supportFragmentManager, "tag_picker")
        }
    }

    private fun updateCounts(db : DBHelper) {
        val allGames = db.getPlayedGamesCount()
        val wonGames = db.getWonGamesCount()
        findViewById<TextView>(R.id.playedGames).text = db.getPlayedGamesCount().toString()
        findViewById<TextView>(R.id.wonGames).text = wonGames.toString()
        findViewById<TextView>(R.id.lostGames).text = (allGames - wonGames).toString()
        findViewById<ProgressBar>(R.id.gameProgress).progress = if (allGames != 0) (wonGames * 100 / allGames) else 0
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ContextWrapper(newBase.setAppLocale("en")))
    }
}

fun Context.setAppLocale(language: String): Context {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = resources.configuration
    config.setLocale(locale)
    config.setLayoutDirection(locale)
    return createConfigurationContext(config)
}