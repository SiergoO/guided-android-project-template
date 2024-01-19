package com.template.cleanlibrary.feature.library.data.repository

import com.template.cleanlibrary.feature.library.domain.repository.LibraryRepository

class LibraryRepositoryImpl : LibraryRepository {

    override suspend fun loadBooksBySearchQuery(query: String): List<String> {
        return listOf("Joe Rowling - Harry Potter and philosopher's stone")
    }
}