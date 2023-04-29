package com.example.newsapp.model

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("status")
    val status: String = "",

    @SerializedName("totalResults")
    val totalResults: Int = 0,

    @SerializedName("articles")
    val articles: List<Articles> = emptyList()
)