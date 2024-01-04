package com.template.cleanlibrary

import android.app.Application
import com.template.cleanlibrary.core.data.di.dataModules
import com.template.cleanlibrary.core.domain.di.domainModules
import com.template.cleanlibrary.feature.library.di.libraryModule
import com.template.cleanlibrary.feature.second.di.secondModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(libraryModule, secondModule)
            modules(domainModules)
            modules(dataModules)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}