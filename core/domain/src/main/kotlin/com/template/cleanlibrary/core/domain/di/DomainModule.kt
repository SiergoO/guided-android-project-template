package com.template.cleanlibrary.core.domain.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
}

val coroutineDispatcherModule = module {
    factory(named("IO")) { Dispatchers.IO }
    factory(named("Main")) { Dispatchers.Main }
    factory(named("Default")) { Dispatchers.Default }
}

val domainModules = listOf(
    useCaseModule,
    coroutineDispatcherModule
)