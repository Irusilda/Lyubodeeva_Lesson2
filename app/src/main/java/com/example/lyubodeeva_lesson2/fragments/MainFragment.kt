package com.example.lyubodeeva_lesson2.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentMainBinding


class MainFragment : Fragment() {

lateinit var binding: FragmentMainBinding

    @SuppressLint("UseSupportActionBar")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

binding = FragmentMainBinding.inflate(inflater)

    val toolbar = binding.root.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
    toolbar.setTitle(R.string.main_frad_bar_title)
    (activity as AppCompatActivity).setSupportActionBar(toolbar)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBtnActivity.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.place_holder, LoginFragment())
                .commit()
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

    }
}