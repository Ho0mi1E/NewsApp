package com.example.newsapp.domain.di

import com.example.newsapp.data.NewsRepositoryImpl
import com.example.newsapp.domain.NewsRepository
import com.example.newsapp.domain.interactor.NewsInteractor
import com.example.newsapp.domain.interactor.NewsInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<NewsInteractor> { NewsInteractorImpl(repository = get()) }
    single<NewsRepository> { NewsRepositoryImpl(api = get()) }
}