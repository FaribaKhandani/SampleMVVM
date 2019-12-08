package com.sample.mvvm.ui.main_page

import androidx.databinding.ObservableField
import com.sample.mvvm.data.model.artist.ArtistData

class ArtistItemViewModel(artistData: ArtistData) {
    var name: ObservableField<String> = ObservableField()
    var listeners: ObservableField<String> = ObservableField()
    var imageUrl: ObservableField<String> = ObservableField()

    init {
        name.set(artistData.name)
        listeners.set(artistData.listeners)
        imageUrl.set(artistData.images?.get(2)?.url)

    }

}