package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentKazanOfficeBinding


class KazanOfficeFragment : Fragment(), CustomIcon, CustomTitle {

lateinit var binding: FragmentKazanOfficeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKazanOfficeBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = KazanOfficeFragment()
    }

    override fun getTitleRes(): Int = R.string.offices_frad_bar_title
    override fun getIconRes(): Int = R.drawable.ic_baseline_arrow_back_24
}