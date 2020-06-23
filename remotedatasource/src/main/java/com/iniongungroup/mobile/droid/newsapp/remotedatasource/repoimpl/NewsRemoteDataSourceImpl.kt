package com.iniongungroup.mobile.droid.newsapp.remotedatasource.repoimpl

import com.iniongungroup.mobile.droid.newsapp.remotedatasource.services.NewsService
import com.iniongungroup.mobile.droid.newsapp.repository.remotedatasource.INewsRemoteDataSource
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

class NewsRemoteDataSourceImpl @Inject constructor(
    retrofit: Retrofit
): INewsRemoteDataSource {

    private val newsService = retrofit.create(NewsService::class.java)

    override fun getNews(page: Int) = newsService.getNews(page)
}