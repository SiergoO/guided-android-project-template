package com.template.cleanlibrary.core.data.repository

import com.template.cleanlibrary.core.domain.repository.BookRepository

class BookRepositoryImpl : BookRepository {

    override suspend fun getBookDetailsById(bookId: Int): String {
        return "Harry Potter and philosopher's stone"
    }

    override suspend fun getAuthorDetailsById(authorId: Int): String {
        return "Joe Rowling"
    }
}