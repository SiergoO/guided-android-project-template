package com.template.domain.usecase.di

import com.template.domain.usecase.GetFirstTitleUse
import com.template.domain.usecase.GetSecondTitleUseCase
import com.template.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

val useCaseModule = module {
    single { Dispatchers.IO }
    factory { GetFirstTitleUse(get(), get()) }
    factory { GetSecondTitleUseCase(get(), get()) }
}

val domainModules = listOf(
    useCaseModule
)