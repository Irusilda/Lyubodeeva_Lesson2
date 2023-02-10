package com.example.lyubodeeva_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToSecond: Button = findViewById(R.id.firstActBtn)
        val btnRussian: Button = findViewById(R.id.russianBtn)
        val btnEnglish: Button = findViewById(R.id.englishBtn)
        val textMain: TextView = findViewById(R.id.textView)

        btnToSecond.setOnClickListener {
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
        }
    }
}