package com.iniongungroup.mobile.droid.newsapp.newsdetails

import com.iniongungroup.mobile.droid.newsapp.common.base.BaseActivity
import com.iniongungroup.mobile.droid.newsapp.entities.Article
import com.iniongungroup.mobile.droid.newsapp.entities.EXTRA_ARTICLE
import com.iniongungroup.mobile.droid.newsapp.newsdetails.databinding.NewsDetailsActivityBinding
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 02/07/2020.
 * For News App project.
 */

class NewsDetailsActivity: BaseActivity<NewsDetailsActivityBinding, NewsDetailsActivityViewModel>() {

    @Inject lateinit var newsDetailsActivityViewModel: NewsDetailsActivityViewModel

    private lateinit var binding: NewsDetailsActivityBinding

    override fun getLayoutId() = R.layout.news_details_activity

    override fun getViewModel() = newsDetailsActivityViewModel

    override fun getBindingVariable() = BR.viewModel

    override fun getBinding(binding: NewsDetailsActivityBinding) { this.binding = binding }

    override fun onResume() {
        super.onResume()

        title = "News Details"

        setUIData(intent.getParcelableExtra(EXTRA_ARTICLE))
    }

    private fun setUIData(article: Article?) {
        article?.let {
            with(binding) {
                authorNameTextView.text = it.author
                sourceNameTextView.text = it.source.name
                datePublishedTextView.text = it.datePublished
                titleTextView.text = it.title
                articleMedia.setImageURI(it.urlToImage)
                descriptionTextView.text = it.description
                contentTextView.text = it.content ?: ""
            }
        }
    }
}