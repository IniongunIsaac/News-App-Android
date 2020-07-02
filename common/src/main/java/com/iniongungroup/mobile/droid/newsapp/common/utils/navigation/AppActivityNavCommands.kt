package com.iniongungroup.mobile.droid.newsapp.common.utils.navigation

import android.content.Context
import android.content.Intent
import com.iniongungroup.mobile.droid.newsapp.common.BuildConfig
import com.iniongungroup.mobile.droid.newsapp.entities.Article
import com.iniongungroup.mobile.droid.newsapp.entities.EXTRA_ARTICLE

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

object AppActivityNavCommands {

    fun getHomeActivityIntent(context: Context) = navigationIntent(context, BuildConfig.HOME_NAV_INTENT)

    fun getNewsDetailsActivityIntent(context: Context, article: Article) = navigationIntent(context, BuildConfig.NEWS_DETAILS_NAV_INTENT).putExtra(EXTRA_ARTICLE, article)

    private fun navigationIntent(context: Context, navAction: String) = Intent(navAction).setPackage(context.packageName)

}