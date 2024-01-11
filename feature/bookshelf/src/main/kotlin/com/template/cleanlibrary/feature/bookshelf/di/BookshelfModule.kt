package com.template.cleanlibrary.feature.bookshelf.di

import com.template.cleanlibrary.feature.bookshelf.domain.GetBookshelfUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.template.cleanlibrary.feature.bookshelf.viewmodel.BookshelfViewModel
import org.koin.core.qualifier.named

private val bookshelfPresentationModule = module {
    viewModelOf(::BookshelfViewModel)
}

private val bookshelfDomainModule = module {
    factory { GetBookshelfUseCase(get(), get(named("IO"))) }
}

val bookshelfModule = module {
    includes(
        bookshelfDomainModule,
        bookshelfPresentationModule,
    )
}