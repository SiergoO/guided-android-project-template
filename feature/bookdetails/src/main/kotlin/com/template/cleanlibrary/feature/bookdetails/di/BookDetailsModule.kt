package com.template.cleanlibrary.feature.bookdetails.di

import com.template.cleanlibrary.feature.bookdetails.domain.usecase.GetBookDetailsByIdUseCase
import com.template.cleanlibrary.feature.bookdetails.viewmodel.BookDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val bookDetailsPresentationModule = module {
    viewModelOf(::BookDetailsViewModel)
}

private val bookDetailsDomainModule = module {
    factory { GetBookDetailsByIdUseCase(get(), get(named("IO"))) }
}

val bookDetailsModule = module {
    includes(
        bookDetailsDomainModule,
        bookDetailsPresentationModule,
    )
}