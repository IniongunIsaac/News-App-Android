package com.iniongungroup.mobile.droid.newsapp.di.modules

import com.iniongungroup.mobile.droid.newsapp.di.scopes.AppScope
import com.iniongungroup.mobile.droid.newsapp.repository.INewsRepo
import com.iniongungroup.mobile.droid.newsapp.repository.NewsRepoImpl
import dagger.Binds
import dagger.Module

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

@Module
abstract class RepositoryModule {

    @Binds
    @AppScope
    internal abstract fun bindNewsRepo(
        repo: NewsRepoImpl
    ): INewsRepo

}