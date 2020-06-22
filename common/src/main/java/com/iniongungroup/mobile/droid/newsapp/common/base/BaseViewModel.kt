package com.iniongungroup.mobile.droid.newsapp.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iniongungroup.mobile.droid.newsapp.common.utils.livedataevent.LiveDataEvent
import com.iniongungroup.mobile.droid.newsapp.common.utils.state.AppResult
import com.iniongungroup.mobile.droid.newsapp.common.utils.state.AppState
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Created by Isaac Iniongun on 22/06/2020.
 * For News App project.
 */

abstract class BaseViewModel: ViewModel(), CoroutineScope {

    val _notificationLiveData = MutableLiveData<LiveDataEvent<AppResult<Unit>>>()
    val notificationLiveData = _notificationLiveData as LiveData<LiveDataEvent<AppResult<Unit>>>

    val compositeDisposable = CompositeDisposable()

    abstract fun handleCoroutineException(throwable: Throwable)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable -> handleCoroutineException(throwable) }

    private val job = Job()

    fun postLoadingState() {
        _notificationLiveData.value = LiveDataEvent(AppResult.loading())
    }

    fun removeLoadingState() {
        _notificationLiveData.value = LiveDataEvent(AppResult.success())
    }

    fun postSuccessMessage(message: String? = null) {
        _notificationLiveData.value = LiveDataEvent(AppResult.success(message = message))
    }

    fun postFailureNotification(message: String? = null) {
        _notificationLiveData.value = LiveDataEvent(AppResult.failed(message))
    }

    fun setMessage(message: String, messageType: AppState) {
        when(messageType) {
            AppState.FAILED -> _notificationLiveData.value = LiveDataEvent(AppResult.failed(message))
            AppState.SUCCESS -> _notificationLiveData.value = LiveDataEvent(AppResult.success(message = message))
        }

    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + coroutineExceptionHandler

    override fun onCleared() {
        super.onCleared()

        job.cancel()

        compositeDisposable.clear()
    }

}