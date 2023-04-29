package com.example.newsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

data class Articles(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,

    @SerializedName("source")
    var modelSource: ModelSource?,

    @SerializedName("author")
    var author: String = "",

    @SerializedName("title")
    var title: String = "",

    @SerializedName("description")
    var description: String = "",

    @SerializedName("url")
    var url: String = "",

    @SerializedName("urlToImage")
    var urlToImage: String = "",

    @SerializedName("publishedAt")
    var publishedAt: String = "",

    var theViewType:Int
)

data class ModelSource(
    @SerializedName("id")
    val id: String? = "",

    @SerializedName("name")
    val name: String? = ""
)