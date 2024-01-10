package com.template.cleanlibrary.core.domain.usecase

import com.template.cleanlibrary.core.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetFirstTitleUseCase(
    private val mainRepository: MainRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): String = withContext(dispatcher) {
        mainRepository.getFirstTitle()
    }
}