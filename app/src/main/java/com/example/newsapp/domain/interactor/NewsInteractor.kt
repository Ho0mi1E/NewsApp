package com.example.newsapp.domain.interactor

import com.example.newsapp.domain.models.BasicNewsItems

interface NewsInteractor {
    suspend fun getNewsForView(searchWord: String): Map<String, List<BasicNewsItems>>
}