package com.example.lyubodeeva_lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lyubodeeva_lesson2.databinding.ItemOfficeBinding

class OfficeAdapter (private val listener: OnItemClickListener?) : RecyclerView.Adapter<OfficeAdapter.MyViewHolder>() {
    var clickAction: (() -> Unit)? = null
    var itemList: List<OfficeData> = emptyList()

    class MyViewHolder(val binding: ItemOfficeBinding) : RecyclerView.ViewHolder(binding.root) {
fun bind(item: OfficeData, listener: OnItemClickListener?){
    itemView.setOnClickListener {
        listener?.onItemClick(item)
    }
}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.layoutParams.width = parent.width
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.itemOffice.text = itemList[position].officeCity

        val item = itemList[position]
        holder.bind(item, listener)
//        holder.binding.itemConteiner.setOnClickListener {

//        }
    }

    override fun getItemCount(): Int = itemList.size
}