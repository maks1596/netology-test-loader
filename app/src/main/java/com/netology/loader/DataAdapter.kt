package com.netology.loader

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netology.loader.databinding.DataBinding
import com.netology.loader.model.Data

internal class DataAdapter(
    private val data: List<Data>
): RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.count()

    class ViewHolder(
        private val binding: DataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) = with(binding){
            directionTitleTextView.text = data.direction.title

            val groupsAmount = data.groups.count()
            groupsAmountTextView.text = itemView.resources.getQuantityString(
                R.plurals.group,
                groupsAmount,
                groupsAmount
            )

            val color = Color.parseColor(data.direction.badge.backgroundColor)
            val badgeColorList = ColorStateList.valueOf(color)
            badgeIcon.backgroundTintList = badgeColorList
        }
    }
}