package com.template.cleanlibrary

import android.app.Application
import com.template.cleanlibrary.app.BuildConfig
import com.template.cleanlibrary.core.data.di.dataModules
import com.template.cleanlibrary.core.domain.di.domainModule
import com.template.cleanlibrary.di.cleanLibraryModule
import com.template.cleanlibrary.feature.authordetails.di.authorDetailsModule
import com.template.cleanlibrary.feature.bookdetails.di.bookDetailsFeatureModule
import com.template.cleanlibrary.feature.bookshelf.di.bookshelfModule
import com.template.cleanlibrary.feature.library.di.libraryModule
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
            modules(
                cleanLibraryModule,
                libraryModule,
                bookDetailsFeatureModule,
                authorDetailsModule,
                bookshelfModule
            )
            modules(domainModule)
            modules(dataModules)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}