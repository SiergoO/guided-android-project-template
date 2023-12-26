package com.template.domain.usecase

import com.template.domain.repository.MainRepository
import com.template.domain.usecase.base.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetFirstTitleUseCase(
    private val mainRepository: MainRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, String>(dispatcher) {

    override suspend fun execute(parameters: Unit): String = mainRepository.getFirstTitle()
}