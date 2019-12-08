package com.sample.mvvm.di.component

import android.app.Application
import com.sample.mvvm.di.builder.ActivityBuilder
import com.sample.mvvm.di.module.AppModule
import com.sample.mvvm.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {
    fun inject(app: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}