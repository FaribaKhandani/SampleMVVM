package com.sample.mvvm.data.remote

import com.sample.mvvm.data.model.artist.ArtistRequest
import com.sample.mvvm.data.model.artist.ArtistResponse
import io.reactivex.Single


interface ApiHelper  {

    fun getArtistApiCall(request: ArtistRequest):Single<ArtistResponse>

}