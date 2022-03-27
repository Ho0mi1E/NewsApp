package com.example.newsapp.domain.models

data class News(
    val article: String?,
    val author: String?,
    val imageUrl: String?,
    val newsUrl: String?,
    val description : String?
) : BasicNewsItems()