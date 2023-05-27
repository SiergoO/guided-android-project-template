package com.template.first.di

import com.template.first.viewmodel.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val firstModule = module {
    viewModelOf(::FirstViewModel)
}