package com.template.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case in a specific [CoroutineDispatcher] that requires [Flow] creation.
     * The [Flow] can be used for subscription to updates coming from repository or anywhere else.
     *
     * @return a [Flow] emitting instances of [R] type data wrapped as a [Result].
     *
     * @param parameters the input parameters to execute the use case with
     */
    operator fun invoke(parameters: P): Flow<Result<R>> = execute(parameters)
        .catch { t -> emit(Result.failure(t)) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}