package com.template.perfectprojecttemplate

import android.app.Application
import com.template.first.di.firstModule
import com.template.second.di.secondModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        startKoin {
            androidContext(this@MainApplication)
            modules(firstModule, secondModule)
//            modules(koinDomainModules)
//            modules(koinPresentationModules)
        }
        super.onCreate()
    }
}