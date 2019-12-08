package com.sample.mvvm.ui.main_page

import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.mvvm.data.DataManager
import com.sample.mvvm.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainActivityModule {
    @Provides
    internal fun provideMainViewModelForFactory(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable
    ): MainViewModel {
        return MainViewModel(
            dataManager,
            schedulerProvider,
            compositeDisposable
        )
    }


    @Provides
    fun provideImageAdapter(): ArtistAdapter {
        return ArtistAdapter()
    }

    @Provides
    fun provideLinearLayoutManager(activity: MainActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
}