package com.iniongungroup.mobile.droid.newsapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iniongungroup.mobile.droid.newsapp.common.base.BaseViewModel
import com.iniongungroup.mobile.droid.newsapp.common.utils.livedataevent.LiveDataEvent
import com.iniongungroup.mobile.droid.newsapp.common.utils.rxscheduler.SchedulerProvider
import com.iniongungroup.mobile.droid.newsapp.common.utils.rxscheduler.subscribeOnIoObserveOnUi
import com.iniongungroup.mobile.droid.newsapp.entities.Article
import com.iniongungroup.mobile.droid.newsapp.repository.INewsRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

class HomeActivityViewModel @Inject constructor(
    private val newsRepo: INewsRepo,
    schedulerProvider: SchedulerProvider
): BaseViewModel() {

    private val _newsArticles = MutableLiveData<List<Article>>()
    val newsArticles: LiveData<List<Article>> = _newsArticles

    private val _article = MutableLiveData<LiveDataEvent<Article>>()
    val article: LiveData<LiveDataEvent<Article>> = _article

    init {
        newsRepo.getNews().subscribeOnIoObserveOnUi(schedulerProvider, {
            _newsArticles.value = it.articles
        }) {

        }
    }

    fun handleNewsItemClicked(article: Article) {
        _article.value = LiveDataEvent(article)
    }

    override fun handleCoroutineException(throwable: Throwable) {
        postFailureNotification(throwable.message)
    }
}