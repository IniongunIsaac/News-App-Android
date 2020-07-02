package com.iniongungroup.mobile.droid.newsapp.di.modules

import com.iniongungroup.mobile.droid.newsapp.di.scopes.PerActivity
import com.iniongungroup.mobile.droid.newsapp.home.HomeActivity
import com.iniongungroup.mobile.droid.newsapp.newsdetails.NewsDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

@Module
abstract class AppActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindHomeActivity(): HomeActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindNewsDetailsActivity(): NewsDetailsActivity

}