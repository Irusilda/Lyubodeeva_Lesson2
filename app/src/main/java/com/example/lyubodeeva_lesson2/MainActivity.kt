package com.example.lyubodeeva_lesson2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lyubodeeva_lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.clockView.changeSecondHandColor(Color.GREEN)
        binding.clockView.changeMinuteHandSize(200)
    }
}