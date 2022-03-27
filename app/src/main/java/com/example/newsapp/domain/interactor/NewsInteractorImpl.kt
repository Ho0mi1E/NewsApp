package com.example.newsapp.domain.interactor

import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.domain.NewsRepository
import com.example.newsapp.domain.models.BasicNewsItems
import com.example.newsapp.toBasicItems

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override suspend fun getNewsForView(searchWord: String): Map<String, List<BasicNewsItems>> {
        val newsResponse: NewsResponse = repository.getNews(searchWord)
        val map = mutableMapOf<String, List<BasicNewsItems>>()
        map[newsResponse.resultsNumber.toString()] = newsResponse.articles.toBasicItems()
        return map
    }
}