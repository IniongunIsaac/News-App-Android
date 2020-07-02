package com.iniongungroup.mobile.droid.newsapp.newsdetails

import com.iniongungroup.mobile.droid.newsapp.common.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 02/07/2020.
 * For News App project.
 */

class NewsDetailsActivityViewModel @Inject constructor() : BaseViewModel() {
    override fun handleCoroutineException(throwable: Throwable) {
        postFailureNotification(throwable.message)
    }
}