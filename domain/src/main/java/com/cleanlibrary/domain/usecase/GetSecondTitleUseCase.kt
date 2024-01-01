package com.cleanlibrary.domain.usecase

import com.cleanlibrary.domain.repository.MainRepository
import com.cleanlibrary.domain.usecase.base.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetSecondTitleUseCase(
    private val mainRepository: MainRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, String>(dispatcher) {

    override suspend fun execute(parameters: Unit): String = mainRepository.getSecondTitle()
}

