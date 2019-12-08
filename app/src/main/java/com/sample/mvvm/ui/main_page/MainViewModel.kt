package com.sample.mvvm.ui.main_page

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.sample.mvvm.data.model.artist.ArtistData
import com.sample.mvvm.data.model.artist.ArtistRequest
import com.sample.mvvm.base.BaseViewModel
import com.sample.mvvm.data.DataManager
import com.sample.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(dataManager, schedulerProvider, compositeDisposable) {
    var artistDataObservableList: ObservableList<ArtistData> = ObservableArrayList()


    fun fetchArtist(request: ArtistRequest) {

        compositeDisposable.add(
            dataManager.getArtistApiCall(request).subscribeOn(schedulerProvider.io()).observeOn(
                schedulerProvider.ui()
            ).subscribe({
                it.artistResult?.artistMatch?.data?.let { it1 ->
                    artistDataObservableList.clear()
                    artistDataObservableList.addAll(it1)
                }
            }) {

                //Handle Error
            })
    }


    fun getArtistRequest(name: String): ArtistRequest {
        return ArtistRequest(name)
    }

    fun searchArtist(artistName: String) {
        fetchArtist(getArtistRequest(artistName))
    }

}