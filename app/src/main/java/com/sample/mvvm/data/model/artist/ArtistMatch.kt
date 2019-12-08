package com.sample.mvvm.data.model.artist

import com.google.gson.annotations.SerializedName

class ArtistMatch {
    @SerializedName("artist")
    var data:MutableList<ArtistData>?=null
}