package com.template.cleanlibrary.core.data.repository

interface BookRepository {

    suspend fun getBookDetailsById(bookId: Int): String

    suspend fun getAuthorDetailsById(authorId: Int): String

    suspend fun getBookshelf(): List<String>

    suspend fun loadBooksBySearchQuery(query: String): List<String>
}