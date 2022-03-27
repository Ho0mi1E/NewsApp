package com.example.newsapp.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.domain.models.BasicNewsItems
import com.example.newsapp.domain.models.DateNews
import com.example.newsapp.domain.models.News
import com.example.newsapp.presentation.clickListner.ShareClickListener
import com.example.newsapp.presentation.recycler.viewHolders.BasicNewsViewHolder
import com.example.newsapp.presentation.recycler.viewHolders.DateViewHolder
import com.example.newsapp.presentation.recycler.viewHolders.NewViewHolder


class NewsAdapter(private val shareNews: ShareClickListener) :
    RecyclerView.Adapter<BasicNewsViewHolder>() {

    private var news = listOf<BasicNewsItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicNewsViewHolder {
        return if (viewType == DateViewHolder.VIEW_TYPE) {
            DateViewHolder.newInstance(parent)
        } else {
            NewViewHolder.newInstance(parent, shareNews)
        }
    }

    override fun onBindViewHolder(holder: BasicNewsViewHolder, position: Int) {
        holder.bind(news[position])
    }
    override fun getItemCount(): Int = news.size

    override fun getItemViewType(position: Int): Int {
        return when (news[position]) {
            is DateNews -> DateViewHolder.VIEW_TYPE
            is News -> NewViewHolder.VIEW_TYPE
        }
    }

    fun submitNews(list: List<BasicNewsItems>) {
        news = list
        notifyDataSetChanged()
    }
}