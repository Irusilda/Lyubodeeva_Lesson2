package com.example.lyubodeeva_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textForSave: TextView
    private lateinit var edit: EditText
    private lateinit var saveTextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textForSave = findViewById(R.id.textViewSecAct)
        edit = findViewById(R.id.editTextSecAct)
        saveTextBtn = findViewById(R.id.   btnForText)

        saveTextBtn.setOnClickListener {
            textForSave.text = edit.text
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