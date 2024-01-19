package com.template.cleanlibrary.feature.library.presentation

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val libraryPresentationModule = module {
    viewModelOf(::LibraryViewModel)
}