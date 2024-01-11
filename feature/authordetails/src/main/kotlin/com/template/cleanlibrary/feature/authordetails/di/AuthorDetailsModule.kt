package com.template.cleanlibrary.feature.authordetails.di

import com.template.cleanlibrary.feature.authordetails.domain.usecase.GetAuthorDetailsByIdUseCase
import com.template.cleanlibrary.feature.authordetails.viewmodel.AuthorDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val authorDetailsPresentationModule = module {
    viewModelOf(::AuthorDetailsViewModel)
}

private val authorDetailsDomainModule = module {
    factory { GetAuthorDetailsByIdUseCase(get(), get(named("IO"))) }
}

val authorDetailsModule = module {
    includes(
        authorDetailsDomainModule,
        authorDetailsPresentationModule,
    )
}