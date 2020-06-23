package com.iniongungroup.mobile.droid.newsapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.iniongungroup.mobile.droid.newsapp.common.base.BaseViewModel
import com.iniongungroup.mobile.droid.newsapp.di.keys.AppViewModelKey
import com.iniongungroup.mobile.droid.newsapp.home.HomeActivityViewModel
import com.iniongungroup.mobile.droid.newsapp.viewmodelfactory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

@Module
abstract class ViewModelsModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @AppViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(
        viewModel: HomeActivityViewModel
    ): BaseViewModel

}