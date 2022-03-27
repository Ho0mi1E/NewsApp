package com.example.newsapp.domain

import com.example.newsapp.data.models.NewsResponse

interface NewsRepository {
    suspend fun getNews(searchWord: String): NewsResponse
}