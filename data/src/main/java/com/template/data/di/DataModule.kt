package com.template.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.template.data.repository.MainRepositoryImpl
import com.template.domain.repository.MainRepository
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    singleOf(::MainRepositoryImpl) { bind<MainRepository>() }
}

val dataModules = listOf(
    repositoryModule
)