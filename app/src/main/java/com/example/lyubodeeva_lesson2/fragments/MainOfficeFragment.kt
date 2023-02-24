package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentMainOfficeBinding

class MainOfficeFragment : Fragment(), CustomTitle {
  lateinit var binding: FragmentMainOfficeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        navigator().backPressed()

        binding = FragmentMainOfficeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.moscowChip.setOnClickListener {
            navigator().showCityFragment(getString(R.string.moscow), getString(R.string.moscow_office_desc))
        }
        binding.kazanChip.setOnClickListener {
           navigator().showCityFragment(getString(R.string.kazan), getString(R.string.kazan_office_desc))
        }
        binding.rostovChip.setOnClickListener {
            navigator().showCityFragment(getString(R.string.rostov), getString(R.string.rostov_office_desc))
        }
        binding.minskChip.setOnClickListener {
           navigator().showCityFragment(getString(R.string.minsk), getString(R.string.minsk_office_desc))
        }
        binding.gomelChip.setOnClickListener {
           navigator().showCityFragment(getString(R.string.gomel), getString(R.string.gomel_office_desc))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainOfficeFragment()



    }
    override fun getTitleRes(): Int = R.string.offices_frad_bar_title

}