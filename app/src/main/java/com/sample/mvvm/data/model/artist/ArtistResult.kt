package com.sample.mvvm.data.model.artist

import com.google.gson.annotations.SerializedName

class ArtistResult {
    @SerializedName("artistmatches")
    var artistMatch: ArtistMatch? = null
}
