package com.template.cleanlibrary.core.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.template.cleanlibrary.core.data.repository.MainRepositoryImpl
import com.template.cleanlibrary.core.domain.repository.MainRepository
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    singleOf(::MainRepositoryImpl) { bind<MainRepository>() }
}

val dataModules = listOf(
    repositoryModule
)