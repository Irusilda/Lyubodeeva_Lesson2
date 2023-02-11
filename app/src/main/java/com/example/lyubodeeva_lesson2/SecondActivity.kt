package com.example.lyubodeeva_lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    private lateinit var textForSave: TextView
    private lateinit var edit: EditText
    private lateinit var saveTextBtn: Button
    private lateinit var goToMainBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textForSave = findViewById(R.id.textViewSecAct)
        edit = findViewById(R.id.editTextSecAct)
        saveTextBtn = findViewById(R.id.   btnForText)

        saveTextBtn.setOnClickListener {
            textForSave.text = edit.text
        }

        goToMainBtn = findViewById(R.id.goToMainBtn)
        goToMainBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result_key", "${edit.text}")
            setResult(RESULT_OK, intent)
            finish()
        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.run{
//            putString("KEY", textForSave.text.toString())
//        }
//
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        textForSave.text = savedInstanceState.getString("KEY")
//    }
}