package com.iniongungroup.mobile.droid.newsapp.entities

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
): BaseEntity() {
    val datePublished: String
        get() = publishedAt.split("T")[0]
}