package com.cleanlibrary.core.domain.usecase

import com.cleanlibrary.core.domain.repository.MainRepository
import com.cleanlibrary.core.domain.usecase.base.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetFirstTitleUseCase(
    private val mainRepository: MainRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, String>(dispatcher) {

    override suspend fun execute(parameters: Unit): String = mainRepository.getFirstTitle()
}