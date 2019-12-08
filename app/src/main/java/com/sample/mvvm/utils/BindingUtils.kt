package com.sample.mvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sample.mvvm.data.model.artist.ArtistData
import com.sample.mvvm.ui.main_page.ArtistAdapter

@BindingAdapter("adapter")
fun addArtistItems(recyclerView: RecyclerView, artistData: List<ArtistData>) {
    recyclerView.adapter?.let {
        val adapter = recyclerView.adapter as ArtistAdapter
            adapter.addItemsToList(artistData.toMutableList())

    }

}

@BindingAdapter("imageLoader")
fun imageLoader(imageView: ImageView, url: String?) {
    val context = imageView.context
    if (url != null && url != "") {
        Glide.with(context)
            .load(url)
            .asBitmap()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }
}
