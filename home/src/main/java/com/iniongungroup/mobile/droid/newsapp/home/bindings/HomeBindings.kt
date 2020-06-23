package com.iniongungroup.mobile.droid.newsapp.home.bindings

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

@BindingAdapter("image")
fun SimpleDraweeView.image(imageURI: String?) {
    imageURI?.let {
        this.setImageURI(it)
    }
}