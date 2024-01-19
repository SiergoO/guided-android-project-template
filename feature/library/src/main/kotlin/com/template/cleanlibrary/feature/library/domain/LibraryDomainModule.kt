package com.template.cleanlibrary.feature.library.domain

import com.template.cleanlibrary.feature.library.domain.usecase.LoadBooksBySearchQueryUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val libraryDomainModule = module {
    factory { LoadBooksBySearchQueryUseCase(get(), get(named("IO"))) }
}