package com.template.cleanlibrary.feature.bookshelf.domain

import com.template.cleanlibrary.core.data.repository.BookRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetBookshelfUseCase(
    private val bookRepository: BookRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<List<String>> = withContext(dispatcher) {
        Result.success(bookRepository.getBookshelf())
    }
}