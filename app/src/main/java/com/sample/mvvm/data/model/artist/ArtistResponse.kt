package com.sample.mvvm.data.model.artist

import com.google.gson.annotations.SerializedName
import com.sample.mvvm.data.model.BaseResponse

class ArtistResponse : BaseResponse() {
    @SerializedName("results")
    var artistResult: ArtistResult? = null

}
