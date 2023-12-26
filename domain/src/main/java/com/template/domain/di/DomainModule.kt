package com.template.domain.di

import com.template.domain.usecase.GetFirstTitleUseCase
import com.template.domain.usecase.GetSecondTitleUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetFirstTitleUseCase(get(), get(named("IO"))) }
    factory { GetSecondTitleUseCase(get(), get(named("IO"))) }
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