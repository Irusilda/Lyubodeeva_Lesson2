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

        binding = FragmentMainOfficeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.moscowChip.setOnClickListener {
            navigator().showMoscowFragment()
        }
        binding.kazanChip.setOnClickListener {
           navigator().showKazanFragment()
        }
        binding.rostovChip.setOnClickListener {
            navigator().showRostovFragment()
        }
        binding.minskChip.setOnClickListener {
           navigator().showMinskFragment()
        }
        binding.gomelChip.setOnClickListener {
           navigator().showGomelFragment()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainOfficeFragment()

    }
    override fun getTitleRes(): Int = R.string.offices_frad_bar_title

}