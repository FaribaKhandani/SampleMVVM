package com.sample.mvvm.base

import androidx.lifecycle.ViewModel
import com.sample.mvvm.data.DataManager
import com.sample.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable) : ViewModel() {
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}