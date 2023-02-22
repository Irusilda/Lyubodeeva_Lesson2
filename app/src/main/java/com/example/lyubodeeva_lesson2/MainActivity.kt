package com.example.lyubodeeva_lesson2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lyubodeeva_lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.apply {
            signInBtnActivity?.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .add(android.R.id.content, LoginFragment())
                    .commit()
            }
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
            officeTitle.visibility = View.GONE
            chipGroup.visibility = View.GONE
            flowBtn.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }

    }
}