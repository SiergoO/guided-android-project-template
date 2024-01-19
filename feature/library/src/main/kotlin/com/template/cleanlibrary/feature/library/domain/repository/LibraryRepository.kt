package com.template.cleanlibrary.feature.library.domain.repository

interface LibraryRepository {

    suspend fun loadBooksBySearchQuery(query: String): List<String>
}