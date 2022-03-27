package com.example.newsapp.data.retrofit

import com.example.newsapp.data.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String?,
        @Query("from") fromDate: String?,
        @Query("to") toDate: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String = "relevancy",
        @Query("page") pageNumber: Int = 1,
        @Query("sources") sources: String = "RBC",
        @Query("pageSize") pageSize: Int = 20,
        @Query("apiKey") apiKey: String = RetrofitClient.BASE_API_KEY
    ): NewsResponse
}
