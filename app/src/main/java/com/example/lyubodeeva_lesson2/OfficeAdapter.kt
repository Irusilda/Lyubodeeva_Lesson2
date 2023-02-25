package com.example.lyubodeeva_lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lyubodeeva_lesson2.databinding.ItemOfficeBinding

class OfficeAdapter : RecyclerView.Adapter<OfficeAdapter.MyViewHolder>() {

    var itemList: List<OfficeData> = emptyList()

    class MyViewHolder(val binding: ItemOfficeBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemOfficeBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.itemOffice.text = itemList[position].officeCity
    }

    override fun getItemCount(): Int = itemList.size
}