package com.template.cleanlibrary.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.template.cleanlibrary.MainActivityViewModel
import org.koin.dsl.module

val cleanLibraryModule = module {
    viewModelOf(::MainActivityViewModel)
}