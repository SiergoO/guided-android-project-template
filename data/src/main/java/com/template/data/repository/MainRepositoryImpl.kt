package com.template.data.repository

import com.template.domain.repository.MainRepository
import kotlinx.coroutines.delay

class MainRepositoryImpl: MainRepository {
    override suspend fun getFirstTitle(): String {
        delay(2000)
        return "First"
    }

    override suspend fun getSecondTitle(): String {
        delay(2000)
        return "Second"
    }
}