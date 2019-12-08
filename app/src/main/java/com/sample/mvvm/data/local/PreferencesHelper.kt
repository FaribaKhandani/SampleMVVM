package com.sample.mvvm.data.local

interface PreferencesHelper {
    fun setAccessToken(accessToken: String)

    fun getAccessToken(): String

}