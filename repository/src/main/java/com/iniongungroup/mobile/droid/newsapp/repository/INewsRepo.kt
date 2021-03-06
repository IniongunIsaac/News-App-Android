package com.iniongungroup.mobile.droid.newsapp.repository

import com.iniongungroup.mobile.droid.newsapp.entities.NewsResponse
import io.reactivex.Observable

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

interface INewsRepo {
    fun getNews(page: Int = 1): Observable<NewsResponse>
}