package com.example.lyubodeeva_lesson2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyubodeeva_lesson2.*
import com.example.lyubodeeva_lesson2.databinding.FragmentMainOfficeBinding

class MainOfficeFragment : Fragment(), CustomTitle, OnItemClickListener {
  lateinit var binding: FragmentMainOfficeBinding
  lateinit var adapter: OfficeAdapter

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

        val city_office = DataStorage.getOfficeList()


        adapter = OfficeAdapter(this@MainOfficeFragment).apply {
            itemList = city_office
        }

        binding.officeRecycler.adapter = adapter
   }

    companion object {

        @JvmStatic
        fun newInstance() = MainOfficeFragment()
    }

    override fun getTitleRes(): Int = R.string.offices_frad_bar_title

    override fun onItemClick(item: OfficeData) {
        val city = item.officeCity
        var desc = ""
        when(city){
            getString(R.string.moscow) -> desc = getString(R.string.moscow_office_desc)
            getString(R.string.kazan) -> desc = getString(R.string.kazan_office_desc)
            getString(R.string.rostov) -> desc = getString(R.string.rostov_office_desc)
            getString(R.string.minsk) -> desc = getString(R.string.minsk_office_desc)
            getString(R.string.gomel) -> desc = getString(R.string.gomel_office_desc)
        }
        navigator().showCityFragment(item.officeCity, desc)
    }

}