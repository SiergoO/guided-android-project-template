package com.cleanlibrary.first.di

import com.cleanlibrary.first.viewmodel.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val firstModule = module {
    viewModelOf(::FirstViewModel)
}