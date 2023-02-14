package com.example.lyubodeeva_lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }
        val btn_toSecond: Button = findViewById(R.id.btn_toSecond)
        btn_toSecond.setOnClickListener {
            launcher?.launch(Intent(this, SecondActivity::class.java))
        }
    }
}