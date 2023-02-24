package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentMainBinding


class MainFragment : Fragment(), CustomTitle, FinishApp {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBtnActivity.setOnClickListener {
            navigator().showLoginFragment()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun getTitleRes(): Int = R.string.main_frag_bar_title
    override fun finishApp() {}
}