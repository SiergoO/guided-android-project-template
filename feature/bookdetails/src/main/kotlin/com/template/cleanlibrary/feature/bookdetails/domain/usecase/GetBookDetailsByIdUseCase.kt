package com.template.cleanlibrary.feature.bookdetails.domain.usecase

import com.template.cleanlibrary.core.domain.repository.BookRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetBookDetailsByIdUseCase(
    private val bookRepository: BookRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(bookId: Int): String = withContext(dispatcher) {
        bookRepository.getBookDetailsById(bookId)
    }
}