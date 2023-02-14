package com.example.lyubodeeva_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity() {
    private var launcher2: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        launcher2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}

        val btn_toThird: Button = findViewById(R.id.btn_toThird)
        btn_toThird.setOnClickListener {
            launcher2?.launch(Intent(this@SecondActivity, ThirdActivity::class.java))
        }

    }
}