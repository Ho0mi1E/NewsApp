package com.example.newsapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.interactor.NewsInteractor
import com.example.newsapp.domain.models.BasicNewsItems
import kotlinx.coroutines.launch

class NewsViewModel(private val interactor: NewsInteractor) : ViewModel() {
    private val _news = MutableLiveData<Map<String, List<BasicNewsItems>>>()
    val news: LiveData<Map<String, List<BasicNewsItems>>> get() = _news


    fun loadNews(searchWord: String) {
        viewModelScope.launch {
            _news.postValue(interactor.getNewsForView(searchWord))
        }
    }
}