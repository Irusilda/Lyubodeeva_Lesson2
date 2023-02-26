package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.DataStorage
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.VacancyAdapter
import com.example.lyubodeeva_lesson2.VacancyBtnData
import com.example.lyubodeeva_lesson2.databinding.FragmentVacancyBinding

class VacancyFragment : Fragment(), CustomTitle {

    lateinit var binding: FragmentVacancyBinding
    lateinit var adapter: VacancyAdapter
    val vacancyItem = DataStorage.getVacancyList()

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

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        adapter = VacancyAdapter().apply {
            itemBtnData.addAll(vacancyItem as MutableList<VacancyBtnData>)

        }
        binding.vacancyRecycle.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = VacancyFragment()
    }

    override fun getTitleRes(): Int = R.string.vacancy_frad_bar_title
}