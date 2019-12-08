package com.sample.mvvm.data.model.artist


import com.google.gson.annotations.SerializedName

class ImageData {

    var localId: Long? = null


    var albumId: String? = null

    @SerializedName("#text")
    var url: String? = null


    @SerializedName("size")
    var size: String? = null
}
