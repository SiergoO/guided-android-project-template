package com.template.cleanlibrary.feature.authordetails.di

import com.template.cleanlibrary.feature.authordetails.viewmodel.AuthorDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authorDetailsModule = module {
    viewModelOf(::AuthorDetailsViewModel)
}