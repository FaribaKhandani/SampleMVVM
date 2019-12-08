package com.sample.mvvm.data

import com.sample.mvvm.data.model.artist.ArtistRequest
import com.sample.mvvm.data.model.artist.ArtistResponse
import io.reactivex.Single

interface DataManager {
    fun getArtistApiCall(request: ArtistRequest): Single<ArtistResponse>

    fun setAccessToken(accessToken: String)

    fun getAccessToken(): String
}