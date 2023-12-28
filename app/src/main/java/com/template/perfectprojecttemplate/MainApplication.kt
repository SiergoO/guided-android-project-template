package com.template.perfectprojecttemplate

import android.app.Application
import com.template.data.di.dataModules
import com.template.domain.di.domainModules
import com.template.first.di.firstModule
import com.template.second.di.secondModule
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