package com.template.cleanlibrary.feature.library

import com.template.cleanlibrary.feature.library.data.libraryDataModule
import com.template.cleanlibrary.feature.library.domain.libraryDomainModule
import com.template.cleanlibrary.feature.library.presentation.libraryPresentationModule
import org.koin.dsl.module

val featureLibraryModule = module {
    includes(
        libraryDataModule,
        libraryDomainModule,
        libraryPresentationModule,
    )
}