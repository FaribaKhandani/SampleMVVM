package com.sample.mvvm.data.remote

import com.sample.mvvm.data.model.artist.ArtistResponse
import io.reactivex.Single
import retrofit2.http.*

interface AppApi {

    @GET("?method=artist.search&api_key=d1bc7a0ae098913780a304057a7283a7&format=json")
    fun getArtist(@Query("artist") name: String?): Single<ArtistResponse>
}