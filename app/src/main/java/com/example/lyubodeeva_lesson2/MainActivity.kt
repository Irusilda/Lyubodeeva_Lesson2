package com.example.lyubodeeva_lesson2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lyubodeeva_lesson2.databinding.ActivityMainBinding
import com.example.lyubodeeva_lesson2.fragments.MainFragment
import com.example.lyubodeeva_lesson2.fragments.MainOfficeFragment
import com.example.lyubodeeva_lesson2.fragments.VacancyFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MainFragment())
                .commit()

            bottomNavigation?.setOnItemSelectedListener { it ->
                when (it.itemId) {
                    R.id.nav_home -> supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_holder, MainFragment())
                        .commit()
                    R.id.nav_vacancies -> supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_holder, VacancyFragment.newInstance())
                        .commit()
                    R.id.nav_offices -> supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_holder, MainOfficeFragment.newInstance())
                        .commit()
                }

                true
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Обработка нажатия на кнопку назад в ActionBar
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


//            signInBtnActivity?.setOnClickListener {
//                supportFragmentManager
//                    .beginTransaction()
//                    .add(android.R.id.content, LoginFragment())
//                    .commit()
//            }
//            contactsBtn.setOnClickListener {
//                changeVisible()
//            }
//            vacanciesBtn.setOnClickListener {
//                changeVisible()
//            }
//            galleryBtn.setOnClickListener{
//                changeVisible()
//            }
//        }
//    }
//
//    private fun changeVisible() {
//        binding.apply {
//            officeTitle.visibility = View.GONE
//            chipGroup.visibility = View.GONE
//            flowBtn.visibility = View.GONE
//            progressBar.visibility = View.VISIBLE
//        }
//
//    }
//
//}