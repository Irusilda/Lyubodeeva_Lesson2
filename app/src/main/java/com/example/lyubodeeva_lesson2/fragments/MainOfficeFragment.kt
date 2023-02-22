package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentMainOfficeBinding

class MainOfficeFragment : Fragment() {
  lateinit var binding: FragmentMainOfficeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.offices_frad_bar_title)
        binding = FragmentMainOfficeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.moscowChip.setOnClickListener {
                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.place_holder,
                        MoscowOfficeFragment.newInstance(getString(R.string.moscow))
                    )
                    .addToBackStack(null)
                    .commit()
            }
        binding.kazanChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance(getString(R.string.kazan)))
                .addToBackStack(null)
                .commit()
        }
        binding.rostovChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance(getString(R.string.rostov)))
                .addToBackStack(null)
                .commit()
        }
        binding.minskChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance(getString(R.string.minsk)))
                .addToBackStack(null)
                .commit()
        }
        binding.gomelChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance(getString(R.string.gomel)))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainOfficeFragment()

    }

}