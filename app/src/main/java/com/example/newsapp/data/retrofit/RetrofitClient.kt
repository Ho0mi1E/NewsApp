package com.example.newsapp.data.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://newsapi.org/v2/"
    const val BASE_API_KEY = "63e8eeed36b4468fa852945b18537b9a"


    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getNewsApi(): NewsApi = getRetrofit().create(NewsApi::class.java)
}