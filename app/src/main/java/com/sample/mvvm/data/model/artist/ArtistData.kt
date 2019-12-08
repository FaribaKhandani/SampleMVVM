package com.sample.mvvm.data.model.artist


import com.google.gson.annotations.SerializedName

class ArtistData {


    @SerializedName("name")
    var name: String? = null

    @SerializedName("listeners")
    var listeners: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("image")
    var images: MutableList<ImageData>? = null

}