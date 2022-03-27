package com.example.newsapp

import com.example.newsapp.data.models.Article
import com.example.newsapp.domain.models.BasicNewsItems
import com.example.newsapp.domain.models.DateNews
import com.example.newsapp.domain.models.News


private fun String.toDate(): String {
    return this.substring(0, 10)
}

fun List<Article>.toBasicItems(): List<BasicNewsItems> {

    val news = mutableListOf<BasicNewsItems>()

    this.forEachIndexed { index, article ->

        if (index == 0) {
            news.add(DateNews(article.publishedAt.toDate()))
        } else if (article.publishedAt.toDate() != this[index - 1].publishedAt.toDate()) {
            news.add(DateNews(article.publishedAt.toDate()))
        }

        news.add(
            News(
                author = article.author,
                article = article.title,
                imageUrl = article.previewUrl,
                newsUrl = article.articleUrl,
                description = article.description?.substring(8)
            )
        )
    }
    return news
}