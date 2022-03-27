package com.example.newsapp.presentation.recycler.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.domain.models.BasicNewsItems

sealed class BasicNewsViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(item: BasicNewsItems)
}