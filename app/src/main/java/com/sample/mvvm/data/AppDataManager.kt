package com.sample.mvvm.data


import com.sample.mvvm.data.model.artist.ArtistRequest
import com.sample.mvvm.data.model.artist.ArtistResponse
import com.sample.mvvm.data.remote.ApiHelper
import com.sample.mvvm.data.local.PreferencesHelper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val mApiHelper: ApiHelper,
    private val mPreferencesHelper: PreferencesHelper
) : DataManager {
    override fun setAccessToken(accessToken: String) {
        mPreferencesHelper.setAccessToken(accessToken)
    }

    override fun getAccessToken(): String {
        return mPreferencesHelper.getAccessToken()
    }

    override fun getArtistApiCall(request: ArtistRequest): Single<ArtistResponse> {
        return mApiHelper.getArtistApiCall(request)
    }


}