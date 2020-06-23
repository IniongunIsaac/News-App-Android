package com.iniongungroup.mobile.droid.newsapp.entities

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)