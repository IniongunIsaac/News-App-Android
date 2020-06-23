package com.iniongungroup.mobile.droid.newsapp.repository

import com.iniongungroup.mobile.droid.newsapp.repository.remotedatasource.INewsRemoteDataSource
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

class NewsRepoImpl @Inject constructor(
    private val newsRemoteDataSource: INewsRemoteDataSource
): INewsRepo {
    override fun getNews(page: Int) = newsRemoteDataSource.getNews(page)
}