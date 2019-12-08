package com.sample.mvvm.di.builder


import com.sample.mvvm.ui.main_page.MainActivity
import com.sample.mvvm.ui.main_page.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}