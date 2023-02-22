package com.example.lyubodeeva_lesson2.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentMainOfficeBinding

class MainOfficeFragment : Fragment() {
  lateinit var binding: FragmentMainOfficeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainOfficeBinding.inflate(inflater)
        val toolbar = binding.root.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.offices_frad_bar_title)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.moscowChip.setOnClickListener {
                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.place_holder,
                        MoscowOfficeFragment.newInstance()
                    )
                    .addToBackStack(null)
                    .commit()
            }
        binding.kazanChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, KazanOfficeFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        binding.rostovChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        binding.minskChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        binding.gomelChip.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MoscowOfficeFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainOfficeFragment()

    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {

            // Обработка нажатия на кнопку назад в ActionBar
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}