package com.cleanlibrary.second.di

import com.cleanlibrary.second.viewmodel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val secondModule = module {
    viewModelOf(::SecondViewModel)
}