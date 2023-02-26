package com.example.lyubodeeva_lesson2

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lyubodeeva_lesson2.databinding.ItemVacancyBinding

class VacancyAdapter : RecyclerView.Adapter<VacancyAdapter.MyViewHolder>() {

    var itemBtnData: MutableList<VacancyBtnData> = mutableListOf()
    var filteredList: MutableList<VacancyBtnData> = mutableListOf()


    @SuppressLint("NotifyDataSetChanged")
    fun filter(text: String) {
        filteredList.clear()
        if (text.isEmpty()) {
            filteredList.addAll(itemBtnData)
        } else {
            itemBtnData.forEach {
                if (it.vacancyBtnTitle.contains(text, true) || it.vacancyBtnSubTitle.contains(text, true) ) {
                    filteredList.add(it)
                }
            }
        }
        notifyDataSetChanged()
        Log.d("MyLog", "$filteredList")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemVacancyBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        with(holder.binding) {
            if(filteredList.isEmpty()){
                item.setTraineeTitle(itemBtnData[position].vacancyBtnTitle)
                item.setTraineeSubtitle(itemBtnData[position].vacancyBtnSubTitle)
                item.setTraineeIcon(itemBtnData[position].vacancyImage)
            } else {
                item.setTraineeTitle(filteredList[position].vacancyBtnTitle)
                item.setTraineeSubtitle(filteredList[position].vacancyBtnSubTitle)
                item.setTraineeIcon(filteredList[position].vacancyImage)
            }
        }
    }

    override fun getItemCount(): Int{
        if (filteredList.isEmpty()) return itemBtnData.size
        else return filteredList.size
    }

    class MyViewHolder(val binding: ItemVacancyBinding)
        : RecyclerView.ViewHolder(binding.root)
}