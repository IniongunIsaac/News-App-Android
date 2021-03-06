package com.iniongungroup.mobile.droid.newsapp.home

import androidx.lifecycle.Observer
import com.iniongungroup.mobile.droid.newsapp.common.adapters.BaseListAdapter
import com.iniongungroup.mobile.droid.newsapp.common.base.BaseActivity
import com.iniongungroup.mobile.droid.newsapp.common.utils.livedataevent.LiveDataEventObserver
import com.iniongungroup.mobile.droid.newsapp.common.utils.navigation.AppActivityNavCommands
import com.iniongungroup.mobile.droid.newsapp.entities.Article
import com.iniongungroup.mobile.droid.newsapp.home.databinding.HomeActivityBinding
import com.iniongungroup.mobile.droid.newsapp.home.databinding.NewsItemBinding
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

class HomeActivity: BaseActivity<HomeActivityBinding, HomeActivityViewModel>() {

    @Inject lateinit var homeActivityViewModel: HomeActivityViewModel

    private lateinit var binding: HomeActivityBinding

    override fun getLayoutId() = R.layout.home_activity

    override fun getViewModel() = homeActivityViewModel

    override fun getBindingVariable() = BR.viewModel

    override fun getBinding(binding: HomeActivityBinding) { this.binding = binding }

    private val newsAdapter by lazy {
        object : BaseListAdapter<NewsItemBinding, Article>(homeActivityViewModel, R.layout.news_item) {

            override fun getEntityBindingVariable() = BR.article

            override fun getViewModelBindingVariable() = BR.viewModel
        }
    }

    override fun onResume() {
        super.onResume()
        binding.newsRecyclerView.adapter = newsAdapter
        observeNewsArticles()
        observeNewsArticle()
    }

    private fun observeNewsArticles() {
        homeActivityViewModel.newsArticles.observe(this, Observer {
            newsAdapter.submitList(it)
        })
    }

    private fun observeNewsArticle() {
        homeActivityViewModel.article.observe(this, LiveDataEventObserver {
            startActivity(AppActivityNavCommands.getNewsDetailsActivityIntent(this, it))
        })
    }

}