package com.iniongungroup.mobile.droid.newsapp.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


const val EXTRA_ARTICLE = "com.iniongungroup.mobile.droid.newsapp.entities.extra.article"

@Parcelize
data class Article(
    val author: String,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
): Parcelable, BaseEntity() {
    val datePublished: String
        get() = publishedAt.split("T")[0]
}