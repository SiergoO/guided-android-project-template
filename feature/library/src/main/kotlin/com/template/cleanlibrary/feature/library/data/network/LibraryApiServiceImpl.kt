package com.template.cleanlibrary.feature.library.data.network

import io.ktor.client.HttpClient

class LibraryApiServiceImpl(private val httpClient: HttpClient): LibraryApiService {

    override suspend fun loadBooksBySearchQuery(query: String): List<String> = emptyList()
}