package com.example.lyubodeeva_lesson2.fragments

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showMainFragment()

    fun showVacancyFragment()

    fun showOfficeFragment()

    fun showCityFragment(cityTitle: String, cityDesc: String)

    fun showLoginFragment()

    fun backPressed()
}