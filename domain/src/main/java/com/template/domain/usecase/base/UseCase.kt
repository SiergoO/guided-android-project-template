package com.template.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, out R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return withContext(coroutineDispatcher) {
            execute(parameters)
        }
    }

    protected abstract suspend fun execute(parameters: P): Result<R>
}