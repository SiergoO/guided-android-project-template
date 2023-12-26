package com.template.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case asynchronously in a specific [CoroutineDispatcher].
     *
     * @return a [R] type data wrapped as a [Result].
     *
     * @param parameters the input parameters to execute the use case with
     */
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let { result ->
                    Result.success(result)
                }
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    protected abstract suspend fun execute(parameters: P): R
}