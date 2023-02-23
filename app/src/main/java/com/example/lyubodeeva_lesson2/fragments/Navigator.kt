package com.example.lyubodeeva_lesson2.fragments

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showMainFragment()

    fun showVacancyFragment()

    fun showOfficeFragment()

    fun showMoscowFragment()

    fun showKazanFragment()

    fun showRostovFragment()

    fun showMinskFragment()

    fun showGomelFragment()

    fun showLoginFragment()

    fun backPressed()
}