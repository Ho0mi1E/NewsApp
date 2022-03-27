package com.example.newsapp.data.di


import com.example.newsapp.data.retrofit.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitClient.getNewsApi() }
}