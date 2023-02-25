package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.DataStorage
import com.example.lyubodeeva_lesson2.VacancyAdapter
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentVacancyBinding

class VacancyFragment : Fragment(), CustomTitle {

    lateinit var binding: FragmentVacancyBinding
    lateinit var adapter: VacancyAdapter
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        navigator().backPressed()

        binding = FragmentVacancyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vacancyItem = DataStorage.getVacancyList()

        adapter = VacancyAdapter().apply {
            itemBtnData = vacancyItem
            clickAction = ::showSometh
        }
        binding.vacancyRecycle.adapter = adapter
    }


    fun showSometh() {
        Toast.makeText(context, "Someth", Toast.LENGTH_LONG).show()

    }

    companion object {

        @JvmStatic
        fun newInstance() = VacancyFragment()
    }

    override fun getTitleRes(): Int = R.string.vacancy_frad_bar_title
}