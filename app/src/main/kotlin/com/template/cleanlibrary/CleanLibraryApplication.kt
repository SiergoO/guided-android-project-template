package com.template.cleanlibrary

import android.app.Application
import com.template.cleanlibrary.app.BuildConfig
import com.template.cleanlibrary.core.data.di.dataModule
import com.template.cleanlibrary.core.domain.di.domainModule
import com.template.cleanlibrary.di.cleanLibraryModule
import com.template.cleanlibrary.feature.authordetails.di.authorDetailsModule
import com.template.cleanlibrary.feature.bookdetails.di.bookDetailsModule
import com.template.cleanlibrary.feature.bookshelf.di.bookshelfModule
import com.template.cleanlibrary.feature.library.featureLibraryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class CleanLibraryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@CleanLibraryApplication)
            // App and feature modules
            modules(
                cleanLibraryModule,
                featureLibraryModule,
                bookDetailsModule,
                authorDetailsModule,
                bookshelfModule
            )
            // Core modules
            modules(
                domainModule,
                dataModule
            )
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}