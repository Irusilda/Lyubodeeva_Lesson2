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

        binding = FragmentVacancyBinding.inflate(inflater)
//        val toolbar = binding.root.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
//        toolbar.setTitle(R.string.vacancy_frad_bar_title)
//        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = VacancyFragment()
    }

    override fun getTitleRes(): Int = R.string.vacancy_frad_bar_title
}