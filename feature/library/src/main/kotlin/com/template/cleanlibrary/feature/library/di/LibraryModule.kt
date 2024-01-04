package com.template.cleanlibrary.feature.library.di

import com.template.cleanlibrary.feature.library.viewmodel.LibraryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val libraryModule = module {
    viewModelOf(::LibraryViewModel)
}