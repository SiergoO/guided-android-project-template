package com.template.cleanlibrary.feature.first.di

import com.template.cleanlibrary.feature.first.viewmodel.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val firstModule = module {
    viewModelOf(::FirstViewModel)
}