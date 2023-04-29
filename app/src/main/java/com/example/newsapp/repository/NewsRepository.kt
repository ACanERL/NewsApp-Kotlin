package com.example.newsapp.repository

import androidx.lifecycle.LiveData
import com.example.newsapp.api.ApiService
import com.example.newsapp.contants.Constants

import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService){
    suspend fun getEveryting()=apiService.getEverything("gold",Constants.apiKey) //search gold news
    suspend fun getGenerals(country:String, category:String, apiKey:String)=apiService.getHeadlinesGeneral(country,category,apiKey)

}