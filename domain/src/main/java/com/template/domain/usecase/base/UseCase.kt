package com.template.domain.usecase.base

abstract class UseCase<in P, R> {

    /** Executes the use case synchronously and returns a [R].
     *
     * @return a [R] type data wrapped as a [Result].
     *
     * @param parameters the input parameters to execute the use case with
     */
    operator fun invoke(parameters: P): Result<R> = try {
        execute(parameters).let { result ->
            Result.success(result)
        }
    } catch (t: Throwable) {
        Result.failure(t)
    }

    protected abstract fun execute(parameters: P): R
}