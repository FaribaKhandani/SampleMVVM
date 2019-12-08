package com.sample.mvvm.data.remote


import com.sample.mvvm.data.model.artist.ArtistRequest
import com.sample.mvvm.data.model.artist.ArtistResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject constructor() : ApiHelper {
    override fun getArtistApiCall(request: ArtistRequest): Single<ArtistResponse> {
        return appApi.getArtist(request.name)
    }

    @Inject
    internal lateinit var appApi: AppApi


}