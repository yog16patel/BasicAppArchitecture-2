package com.example.domain.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class ResultInteractor<in P, out R> {


    operator fun invoke(params: P): Flow<R> {
        return flow {
            emit(doWork(params))
        }
    }

    suspend fun executeSync(params: P): R = doWork(params)

    protected abstract suspend fun doWork(params: P) : R
}