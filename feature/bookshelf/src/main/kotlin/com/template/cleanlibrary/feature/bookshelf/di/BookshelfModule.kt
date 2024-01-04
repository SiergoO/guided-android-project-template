package com.template.cleanlibrary.feature.bookshelf.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.template.cleanlibrary.feature.bookshelf.viewmodel.BookshelfViewModel

val bookshelfModule = module {
    viewModelOf(::BookshelfViewModel)
}