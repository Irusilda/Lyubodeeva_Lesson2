package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentCityOfficeBinding


class CityOfficeFragment : Fragment(), CustomTitle, CustomIcon {

lateinit var binding: FragmentCityOfficeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityOfficeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.moscowOfficeTitle.text = arguments?.getStringArray(ARGS_KEY)?.get(0) ?: "Ошибка"
        binding.moscowOfficeDescription.text = arguments?.getStringArray(ARGS_KEY)?.get(1)
    }

    companion object {
        const val ARGS_KEY = "MAIN_OFFICE_ARGS_KEY"

        fun newInstance() = CityOfficeFragment()

        fun newInstance(messageTitle: String, messageDesc: String): CityOfficeFragment{
            val messageArray = arrayOf(messageTitle, messageDesc)
            val arguments = Bundle().apply {
                putStringArray(ARGS_KEY, messageArray)
            }
            val fragment = CityOfficeFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun getTitleRes(): Int = R.string.offices_frad_bar_title
    override fun getIconRes(): Int = R.drawable.ic_baseline_arrow_back_24



}