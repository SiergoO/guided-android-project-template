package com.template.cleanlibrary.core.data.repository

import com.template.cleanlibrary.core.domain.repository.BookRepository
import kotlinx.coroutines.delay

class BookRepositoryImpl : BookRepository {

    override suspend fun getBookDetailsById(bookId: Int): String {
        return "Harry Potter and philosopher's stone"
    }

    override suspend fun getSecondTitle(): String {
        delay(2000)
        return "Second"
    }
}