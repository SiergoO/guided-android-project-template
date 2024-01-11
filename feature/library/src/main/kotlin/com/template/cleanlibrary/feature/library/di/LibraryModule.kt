package com.template.cleanlibrary.feature.library.di

import com.template.cleanlibrary.feature.library.domain.usecase.LoadBooksBySearchQueryUseCase
import com.template.cleanlibrary.feature.library.viewmodel.LibraryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val libraryPresentationModule = module {
    viewModelOf(::LibraryViewModel)
}

private val libraryDomainModule = module {
    factory { LoadBooksBySearchQueryUseCase(get(), get(named("IO"))) }
}

val libraryModule = module {
    includes(
        libraryDomainModule,
        libraryPresentationModule,
    )
}