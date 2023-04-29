package com.example.newsapp.api

import com.example.newsapp.contants.Constants
import com.example.newsapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query:String,
        @Query("apiKey") apiKey:String
    ):Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun getHeadlinesGeneral(
        @Query("country") country:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String
    ):Response<NewsResponse>

}