package com.example.newsapp.data

import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.data.retrofit.NewsApi
import com.example.newsapp.domain.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(private val api: NewsApi) : NewsRepository {
    override suspend fun getNews(searchWord: String): NewsResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.getEverything(
                query = searchWord,
                fromDate = null,
                toDate = null,
                language = "ru"
            )
        }
    }
}