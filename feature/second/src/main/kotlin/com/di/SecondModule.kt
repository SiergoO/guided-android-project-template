package com.template.cleanlibrary.feature.second.di

import com.template.cleanlibrary.feature.second.viewmodel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val secondModule = module {
    viewModelOf(::SecondViewModel)
}