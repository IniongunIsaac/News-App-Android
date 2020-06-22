package com.iniongungroup.mobile.droid.newsapp.di.component

import com.iniongungroup.mobile.droid.newsapp.NewsApplication
import com.iniongungroup.mobile.droid.newsapp.di.modules.*
import com.iniongungroup.mobile.droid.newsapp.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Isaac Iniongun on 22/06/2020.
 * For News App project.
 */

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        RemoteDataSourceModule::class,
        RepositoryModule::class,
        ViewModelsModule::class,
        AppActivityBindingModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(newsApp: NewsApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindAppInstance(newsApp: NewsApplication): Builder

        fun buildAppComponent(): AppComponent

    }

}