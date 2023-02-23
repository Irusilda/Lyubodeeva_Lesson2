package com.example.lyubodeeva_lesson2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lyubodeeva_lesson2.databinding.ActivityMainBinding
import com.example.lyubodeeva_lesson2.fragments.*

class MainActivity : AppCompatActivity(), Navigator {
    lateinit var binding: ActivityMainBinding
    lateinit var toolbar: Toolbar
    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.place_holder)!!

    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            updateUi()
        }
    }

    private fun updateUi() {
//       toolbar = binding.root.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val fragment = currentFragment

        if (fragment is CustomTitle) {
           toolbar.title = getString(fragment.getTitleRes())
        } else {
            toolbar.title = getString(R.string.app_name)
        }
        if (fragment is CustomIcon) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(fragment.getIconRes())
        }
        else supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.root.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.main_frad_bar_title)

        binding.apply {
            if(savedInstanceState == null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, MainFragment())
                    .commit()
            }

            bottomNavigation?.setOnItemSelectedListener { it ->
                when (it.itemId) {
                    R.id.nav_home -> showMainFragment()
                    R.id.nav_vacancies -> showVacancyFragment()
                    R.id.nav_offices -> showOfficeFragment()
                }
                true
            }
        }
        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
    }
    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }
    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }
    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, fragment)
            .commit()
    }
    private fun launchFragmentBack(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.place_holder, fragment)
            .commit()
    }
    override fun showMainFragment() {
        launchFragment(MainFragment.newInstance())
    }

    override fun showVacancyFragment() {
        launchFragment(VacancyFragment.newInstance())
    }

    override fun showOfficeFragment() {
        launchFragment(MainOfficeFragment.newInstance())
    }

    override fun showMoscowFragment() {
        launchFragmentBack(MoscowOfficeFragment.newInstance())
    }

    override fun showKazanFragment() {
        launchFragmentBack(KazanOfficeFragment.newInstance())
    }

    override fun showRostovFragment() {
        launchFragmentBack(RostovOfficeFragment.newInstance())
    }

    override fun showMinskFragment() {
        launchFragmentBack(MinskOfficeFragment.newInstance())
    }

    override fun showGomelFragment() {
       launchFragmentBack(GomelOfficeFragment.newInstance())
    }

    override fun showLoginFragment() {
        launchFragmentBack(LoginFragment.newInstance())
    }

}

