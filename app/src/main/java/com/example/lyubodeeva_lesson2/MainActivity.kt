package com.example.lyubodeeva_lesson2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

class MySecondActivityContract: ActivityResultContract<String?, String?>(){
    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, SecondActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when {
            resultCode != Activity.RESULT_OK -> null
            else -> intent?.getStringExtra("result_key")
        }
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var textMain: TextView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToSecond: Button = findViewById(R.id.firstActBtn)
        val btnRussian: Button = findViewById(R.id.russianBtn)
        val btnEnglish: Button = findViewById(R.id.englishBtn)
        textMain = findViewById(R.id.textView)
        textMain.text = getString(R.string.first_activity_text)

        val appLocaleRu: LocaleListCompat = LocaleListCompat.forLanguageTags("ru")
        val appLocaleEn: LocaleListCompat = LocaleListCompat.forLanguageTags("en")

        val activityLauncher = registerForActivityResult(MySecondActivityContract()){
                result ->
            if (result != null && result.contains("[A-Za-z0-9!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
                    textMain.text = result
                }
        }

        btnToSecond.setOnClickListener {
//            val myIntent = Intent(this, SecondActivity::class.java)
//            startActivity(myIntent)
            activityLauncher.launch("")
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
//   Для дефолтного отображения текста (если ничего не было передано), а не переданного ранее из второго активити
//    override fun onRestart() {                   //
//        super.onRestart()
//        textMain.text = getString(R.string.first_activity_text)
//
//    }
}