package com.example.hangman

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Result(context: Context, private val image: Int, private val title: Int) : Dialog(context)  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.result_dialog)
        setCancelable(false)
        window?.setGravity(Gravity.BOTTOM)

        val height = Resources.getSystem().displayMetrics.heightPixels * 0.4
        window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, height.toInt())
        findViewById<TextView>(R.id.resultInfo).setText(title)
        findViewById<ImageView>(R.id.resultImage).setImageResource(image)

        findViewById<Button>(R.id.againButton).setOnClickListener {
            val intent = Intent(this.context, Game::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            dismiss()
            context.startActivity(intent)
        }

        findViewById<Button>(R.id.menuButton).setOnClickListener {
            val intent = Intent(this.context, Menu::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            dismiss()
            context.startActivity(intent)
        }

    }
}