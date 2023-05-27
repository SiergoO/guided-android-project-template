package com.template.domain.usecase;

import com.template.domain.repository.MainRepository
import com.template.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetSecondTitleUseCase(
    private val mainRepository: MainRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Nothing, String>(dispatcher) {

    override suspend fun execute(parameters: Nothing): Result<String> =
        try {
            val secondTitle = mainRepository.getSecondTitle()
            Result.success(secondTitle)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

