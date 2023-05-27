package com.template.second.di

import com.template.second.viewmodel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val secondModule = module {
    viewModelOf(::SecondViewModel)
}