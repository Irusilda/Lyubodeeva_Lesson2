package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lyubodeeva_lesson2.R
import com.example.lyubodeeva_lesson2.databinding.FragmentMoscowOfficeBinding


class MoscowOfficeFragment : Fragment() {
lateinit var binding: FragmentMoscowOfficeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.offices_frad_bar_title)

        binding = FragmentMoscowOfficeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
        officeCityTitle.text = arguments?.getString(ARGS_KEY)
//            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
       when(officeCityTitle.text){
           "Москва" -> officeDescription.text = context?.getString(R.string.moscow_office_desc)
           "Казань" -> officeDescription.text= context?.getString(R.string.kazan_office_desc)
           "Ростов-на-Дону" -> officeDescription.text= context?.getString(R.string.rostov_office_desc)
           "Минск" -> officeDescription.text= context?.getString(R.string.minsk_office_desc)
           "Гомель" -> officeDescription.text= context?.getString(R.string.gomel_office_desc)
       }

        }
    }

    companion object {
const val ARGS_KEY = "Office_fragment_key"
        @JvmStatic
        fun newInstance() = MoscowOfficeFragment()
        fun newInstance (message: String): MoscowOfficeFragment {
            val arguments = Bundle().apply {
                putString(ARGS_KEY, message)
            }
            val fragment = MoscowOfficeFragment()

            fragment.arguments = arguments
            return fragment
        }
    }

}