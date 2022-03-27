package com.example.newsapp.presentation.recycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.domain.models.BasicNewsItems
import com.example.newsapp.domain.models.News
import com.example.newsapp.presentation.clickListner.ShareClickListener
import kotlinx.android.synthetic.main.item_news.view.*

class NewViewHolder(item: View, val clickListener: ShareClickListener) : BasicNewsViewHolder(item) {
    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(item: ViewGroup, clickListener: ShareClickListener) = NewViewHolder(
            LayoutInflater.from(item.context).inflate(R.layout.item_news, item, false),
            clickListener
        )
    }

    override fun bind(item: BasicNewsItems) {
        (item as News).apply {
            Glide
                .with(itemView.context)
                .load(imageUrl)
                .into(itemView.imageNews)
            itemView.apply {
                textTitleNews.text = article
                textAuthor.text = author
                textDescriptionNews.text = description
                btnShare.setOnClickListener {
                    clickListener.clickListener(url = newsUrl)
                }
            }
        }
    }
}