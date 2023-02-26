package com.example.lyubodeeva_lesson2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lyubodeeva_lesson2.databinding.ItemOfficeBelBinding
import com.example.lyubodeeva_lesson2.databinding.ItemOfficeBinding

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(item: OfficeData, listener: OnItemClickListener?){
        itemView.setOnClickListener {
            listener?.onItemClick(item)
        }
    }
}

class RusViewHolder(val binding: ItemOfficeBinding): BaseViewHolder(binding.root)

class BelViewHolder(val binding: ItemOfficeBelBinding): BaseViewHolder(binding.root)