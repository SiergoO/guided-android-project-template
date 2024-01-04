package com.template.cleanlibrary.core.data.repository

import com.template.cleanlibrary.core.domain.repository.MainRepository
import kotlinx.coroutines.delay

class MainRepositoryImpl: MainRepository {
    override suspend fun getFirstTitle(): String {
        delay(2000)
        return "Library"
    }

    override suspend fun getSecondTitle(): String {
        delay(2000)
        return "Second"
    }
}