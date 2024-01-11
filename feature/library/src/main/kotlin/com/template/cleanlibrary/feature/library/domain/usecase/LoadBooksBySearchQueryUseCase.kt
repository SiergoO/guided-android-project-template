package com.template.cleanlibrary.feature.library.domain.usecase

import com.template.cleanlibrary.core.domain.repository.BookRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LoadBooksBySearchQueryUseCase(
    private val bookRepository: BookRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(searchQuery: String): Result<List<String>> = withContext(dispatcher) {
        Result.success(bookRepository.loadBooksBySearchQuery(searchQuery))
    }
}