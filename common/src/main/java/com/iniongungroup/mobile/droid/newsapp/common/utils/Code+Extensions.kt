package com.iniongungroup.mobile.droid.newsapp.common.utils

import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

fun runAfter(delay: Long = 500, block: () -> Unit) {
    Timer().schedule(delay) {
        block.invoke()
    }
}