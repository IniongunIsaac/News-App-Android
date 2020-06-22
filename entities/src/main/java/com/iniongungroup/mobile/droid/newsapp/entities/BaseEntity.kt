package com.iniongungroup.mobile.droid.newsapp.entities

/**
 * Created by Isaac Iniongun on 23/06/2020.
 * For News App project.
 */

abstract class BaseEntity {
    val uniqueKey: String = java.util.UUID(10, 10).toString()
    abstract override fun equals(other: Any?): Boolean
}