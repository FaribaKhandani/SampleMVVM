package com.sample.mvvm.ui.main_page

import com.sample.mvvm.data.DataManager
import com.sample.mvvm.data.model.artist.*
import com.sample.mvvm.rx.TestSchedulerProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @Mock
    lateinit var dataManager: DataManager


    private lateinit var viewModel: MainViewModel
    private lateinit var mTestScheduler: TestScheduler
    private lateinit var compositeDisposable: CompositeDisposable
    @Before
    @Throws(Exception::class)
    fun setUp() {
        mTestScheduler = TestScheduler()
        compositeDisposable = CompositeDisposable()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        viewModel = MainViewModel(dataManager, testSchedulerProvider, compositeDisposable)
    }

    @Test
    fun getArtist() {
        val artistResponse = getMockArtistResponse()
        val artistRequest = getMockArtistRequest()
        doReturn(Single.just(artistResponse))
            .`when`(dataManager)
            .getArtistApiCall(artistRequest)

        viewModel.fetchArtist(artistRequest)
        mTestScheduler.triggerActions()
        assertEquals(
            artistResponse.artistResult?.artistMatch?.data?.get(0),
            viewModel.artistDataObservableList[0]
        )
    }


    private fun getMockArtistResponse(): ArtistResponse {
        val dataList: MutableList<ArtistData> = mutableListOf(ArtistData())
        val artistData = ArtistData()
        artistData.name = "gaga"
        artistData.listeners = "28555"
        dataList.add(artistData)
        val artistMatch = ArtistMatch()
        artistMatch.data = dataList.toMutableList()
        val artistResult = ArtistResult()
        artistResult.artistMatch = artistMatch
        val artistResponse = ArtistResponse()
        artistResponse.artistResult = artistResult
        return artistResponse
    }

    private fun getMockArtistRequest(): ArtistRequest {
        return ArtistRequest("gaga")
    }

}