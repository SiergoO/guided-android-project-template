package com.cleanlibrary.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.cleanlibrary.data.repository.MainRepositoryImpl
import com.cleanlibrary.domain.repository.MainRepository
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    singleOf(::MainRepositoryImpl) { bind<MainRepository>() }
}

val dataModules = listOf(
    repositoryModule
)