package com.template.cleanlibrary.feature.bookdetails.di

import com.template.cleanlibrary.feature.bookdetails.viewmodel.BookDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val bookDetailsModule = module {
    viewModelOf(::BookDetailsViewModel)
}