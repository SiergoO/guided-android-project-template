package com.template.cleanlibrary.feature.library.data.network

interface LibraryApiService {

    suspend fun loadBooksBySearchQuery(query: String): List<String>
}