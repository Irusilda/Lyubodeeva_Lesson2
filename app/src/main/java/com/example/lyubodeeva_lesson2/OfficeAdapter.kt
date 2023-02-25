package com.example.lyubodeeva_lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lyubodeeva_lesson2.databinding.ItemOfficeBelBinding
import com.example.lyubodeeva_lesson2.databinding.ItemOfficeBinding

class OfficeAdapter(private val listener: OnItemClickListener?) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var itemList: List<OfficeData> = emptyList()
    override fun getItemViewType(position: Int): Int = itemList[position].viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ItemOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.layoutParams.width = parent.width


        return when(viewType){
            R.layout.item_office -> RusViewHolder(ItemOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> BelViewHolder(ItemOfficeBelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = itemList[position]
        when(holder) {
            is RusViewHolder -> {
                with(holder.binding) {
                    itemOffice.text = itemList[position].officeCity
                    holder.bind(item, listener)
                }
            }
            is BelViewHolder -> {
                with(holder.binding) {
                    itemOfficeBel.text = itemList[position].officeCity
                    holder.bind(item, listener)
                }
            }
        }
    }

    override fun getItemCount(): Int  = itemList.size
}