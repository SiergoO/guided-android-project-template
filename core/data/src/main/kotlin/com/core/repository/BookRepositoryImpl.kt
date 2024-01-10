package com.template.cleanlibrary.core.data.repository

import com.template.cleanlibrary.core.domain.repository.BookRepository
import kotlinx.coroutines.delay

class BookRepositoryImpl: BookRepository {
    override suspend fun getBookDetailsById(): String {
        delay(2000)
        return "Library"
    }

    override suspend fun getSecondTitle(): String {
        delay(2000)
        return "Second"
    }
}