package com.template.cleanlibrary.core.domain.usecase

import com.template.cleanlibrary.core.domain.repository.MainRepository
import com.template.cleanlibrary.core.domain.usecase.base.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetSecondTitleUseCase(
    private val mainRepository: MainRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, String>(dispatcher) {

    override suspend fun execute(parameters: Unit): String = mainRepository.getSecondTitle()
}
