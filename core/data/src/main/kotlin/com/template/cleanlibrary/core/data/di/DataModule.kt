package com.template.cleanlibrary.core.data.di

import com.template.cleanlibrary.core.data.repository.BookRepositoryImpl
import com.template.cleanlibrary.core.domain.repository.BookRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private val repositoryModule = module {
    singleOf(::BookRepositoryImpl) { bind<BookRepository>() }
}

val dataModule = module {
    includes(repositoryModule)
}