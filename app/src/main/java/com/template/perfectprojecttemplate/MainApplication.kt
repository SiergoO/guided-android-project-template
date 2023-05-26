package com.template.perfectprojecttemplate

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        startKoin {
            androidContext(this@MainApplication)
//            modules(koinDataSourceModules)
//            modules(koinDomainModules)
//            modules(koinPresentationModules)
        }
        super.onCreate()
    }
}