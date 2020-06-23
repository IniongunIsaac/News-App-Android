package com.iniongungroup.mobile.droid.newsapp.remotedatasource.services

import com.iniongungroup.mobile.droid.newsapp.entities.NewsResponse
import com.iniongungroup.mobile.droid.newsapp.remotedatasource.BuildConfig
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

interface NewsService {
    @GET("everything")
    fun getNews(@Query("page") page: Int = 1, @Query("q") q: String = "bitcoin", @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY): Observable<NewsResponse>
}