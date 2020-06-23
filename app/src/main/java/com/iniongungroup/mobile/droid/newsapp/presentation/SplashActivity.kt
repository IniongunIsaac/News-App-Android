package com.iniongungroup.mobile.droid.newsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iniongungroup.mobile.droid.newsapp.R
import com.iniongungroup.mobile.droid.newsapp.common.utils.navigation.AppActivityNavCommands
import com.iniongungroup.mobile.droid.newsapp.common.utils.runAfter

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        runAfter {
            startActivity(AppActivityNavCommands.getHomeActivityIntent(this))
        }

    }
}