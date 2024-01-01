package com.cleanlibrary.core.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.cleanlibrary.core.data.repository.MainRepositoryImpl
import com.cleanlibrary.core.domain.repository.MainRepository
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    singleOf(::MainRepositoryImpl) { bind<MainRepository>() }
}

val dataModules = listOf(
    repositoryModule
)