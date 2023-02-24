package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentVacancyBinding

class VacancyFragment : Fragment(), CustomTitle {

    lateinit var binding: FragmentVacancyBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        navigator().backPressed()

        binding = FragmentVacancyBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = VacancyFragment()
    }

    override fun getTitleRes(): Int = R.string.vacancy_frad_bar_title
}