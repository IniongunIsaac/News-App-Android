package com.iniongungroup.mobile.droid.newsapp.di.modules

import com.iniongungroup.mobile.droid.newsapp.di.scopes.AppScope
import com.iniongungroup.mobile.droid.newsapp.remotedatasource.repoimpl.NewsRemoteDataSourceImpl
import com.iniongungroup.mobile.droid.newsapp.repository.remotedatasource.INewsRemoteDataSource
import dagger.Binds
import dagger.Module

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

@Module
abstract class RemoteDataSourceModule {

    @Binds
    @AppScope
    internal abstract fun bindNewsRemoteDataSource(
        remotedatasource: NewsRemoteDataSourceImpl
    ): INewsRemoteDataSource

}