package com.template.cleanlibrary.core.data.repository

class BookRepositoryImpl : BookRepository {

    override suspend fun getBookDetailsById(bookId: Int): String {
        return "Harry Potter and philosopher's stone"
    }

    override suspend fun getAuthorDetailsById(authorId: Int): String {
        return "Joe Rowling"
    }

    override suspend fun getBookshelf(): List<String> {
        return listOf("Joe Rowling - Harry Potter and philosopher's stone")
    }

    override suspend fun loadBooksBySearchQuery(query: String): List<String> {
        return listOf("Joe Rowling - Harry Potter and philosopher's stone")
    }
}