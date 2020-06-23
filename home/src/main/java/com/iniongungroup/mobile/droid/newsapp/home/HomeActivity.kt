package com.iniongungroup.mobile.droid.newsapp.home

import androidx.lifecycle.Observer
import com.iniongungroup.mobile.droid.newsapp.common.base.BaseActivity
import com.iniongungroup.mobile.droid.newsapp.home.databinding.HomeActivityBinding
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

    override fun onResume() {
        super.onResume()
        observeNewsArticles()

    }

    private fun observeNewsArticles() {
        homeActivityViewModel.newsArticles.observe(this, Observer {

        })
    }

}