package com.example.newsapp.presentation.recycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.domain.models.BasicNewsItems
import com.example.newsapp.domain.models.DateNews
import kotlinx.android.synthetic.main.item_date.view.*

class DateViewHolder(item: View) : BasicNewsViewHolder(item) {
    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(item: ViewGroup) = DateViewHolder(
            LayoutInflater.from(item.context).inflate(
                R.layout.item_date, item, false
            )
        )
    }

    override fun bind(item: BasicNewsItems) {
        itemView.textDate.text = (item as DateNews).date
    }
}