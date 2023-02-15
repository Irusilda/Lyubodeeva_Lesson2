package com.example.lyubodeeva_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lyubodeeva_lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            contactsBtn.setOnClickListener {
                changeVisible()
            }
            vacanciesBtn.setOnClickListener {
                changeVisible()
            }
            galleryBtn.setOnClickListener{
                changeVisible()
            }
        }
    }

    private fun changeVisible() {
        binding.apply {
            groupForHide.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }

    }
}