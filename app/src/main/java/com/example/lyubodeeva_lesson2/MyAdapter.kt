package com.example.lyubodeeva_lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lyubodeeva_lesson2.databinding.ItemVacancyBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var clickAction: (() -> Unit)? = null
    var itemBtnData: List<VacancyBtnData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemVacancyBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        with(holder.binding) {
            item.setTraineeTitle(itemBtnData[position].vacancyBtnTitle)
            item.setTraineeSubtitle(itemBtnData[position].vacancyBtnSubTitle)
            item.setTraineeIcon(itemBtnData[position].vacancyImage)

            itemContainer.setOnClickListener {
                clickAction?.invoke()
            }
        }

    }

    override fun getItemCount(): Int = itemBtnData.size

    class MyViewHolder(val binding: ItemVacancyBinding)
        : RecyclerView.ViewHolder(binding.root)
}