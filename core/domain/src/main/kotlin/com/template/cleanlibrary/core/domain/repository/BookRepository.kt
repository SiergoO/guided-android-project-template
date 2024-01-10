package com.template.cleanlibrary.core.domain.repository

interface BookRepository {

    suspend fun getBookDetailsById(bookId: Int): String

    suspend fun getSecondTitle(): String
}