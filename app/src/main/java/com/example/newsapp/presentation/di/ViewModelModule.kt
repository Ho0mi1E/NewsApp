package com.example.newsapp.presentation.di

import com.example.newsapp.presentation.viewModel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel() { NewsViewModel(interactor = get()) }
}