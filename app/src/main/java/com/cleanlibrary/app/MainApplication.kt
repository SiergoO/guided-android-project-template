package com.cleanlibrary.app

import android.app.Application
import com.cleanlibrary.data.di.dataModules
import com.cleanlibrary.domain.di.domainModules
import com.cleanlibrary.first.di.firstModule
import com.cleanlibrary.second.di.secondModule
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
            modules(firstModule, secondModule)
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