package com.example.lyubodeeva_lesson2

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToSecond: Button = findViewById(R.id.firstActBtn)
        val btnRussian: Button = findViewById(R.id.russianBtn)
        val btnEnglish: Button = findViewById(R.id.englishBtn)
        val textMain: TextView = findViewById(R.id.textView)
        textMain.text = getString(R.string.first_activity_text)

        val appLocaleRu: LocaleListCompat = LocaleListCompat.forLanguageTags("ru")
        val appLocaleEn: LocaleListCompat = LocaleListCompat.forLanguageTags("en")

        btnToSecond.setOnClickListener {
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
        }

        btnEnglish.setOnClickListener {
            setLocale(appLocaleEn)
//           Log.d("MyLog", "${LocaleListCompat.getAdjustedDefault()}")
         }

        btnRussian.setOnClickListener {
            setLocale(appLocaleRu)
        }
    }
    private fun setLocale(appLocale: LocaleListCompat){
        AppCompatDelegate.setApplicationLocales(appLocale)
    }
}