package com.cleanlibrary.domain.usecase.base

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case asynchronously in a specific [CoroutineDispatcher]. Handles exceptions including
     * coroutine's cancellation exception.
     *
     * @return a [R] type data wrapped as a [Result].
     *
     * @param parameters the input parameters to execute the use case with
     */
    suspend operator fun invoke(parameters: P): Result<R> = try {
        withContext(coroutineDispatcher) {
            execute(parameters).let { result ->
                Result.success(result)
            }
        }
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }

    protected abstract suspend fun execute(parameters: P): R
}