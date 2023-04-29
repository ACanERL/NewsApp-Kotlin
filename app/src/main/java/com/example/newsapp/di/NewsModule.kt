package com.example.newsapp.di

import com.example.newsapp.api.ApiService
import com.example.newsapp.contants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    @Singleton
    fun provideRetrofintInstance():ApiService=Retrofit.Builder()
        .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        .create(ApiService::class.java)
}