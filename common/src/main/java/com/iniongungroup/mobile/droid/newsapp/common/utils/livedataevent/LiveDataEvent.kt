package com.iniongungroup.mobile.droid.newsapp.common.utils.livedataevent

/**
 * Created by Isaac Iniongun on 22/06/2020.
 * For News App project.
 */

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class LiveDataEvent<out T>(private val content: T) {

    @Suppress("MemberVisibilityCanBePrivate")
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}