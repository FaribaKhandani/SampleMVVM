package com.sample.mvvm.data.local

import android.content.Context
import android.content.SharedPreferences
import com.sample.mvvm.di.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(context: Context, @PreferenceInfo prefFileName: String) :
    PreferencesHelper {
    private var mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun setAccessToken(accessToken: String) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
    }

    override fun getAccessToken(): String {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")!!
    }


}

const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"