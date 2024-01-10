package com.template.cleanlibrary.core.domain.usecase

import com.template.cleanlibrary.core.domain.repository.BookRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetSecondTitleUseCase(
    private val bookRepository: BookRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): String = withContext(dispatcher) {
        bookRepository.getSecondTitle()
    }
}