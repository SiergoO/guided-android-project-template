package com.cleanlibrary.domain.repository

interface MainRepository {

    suspend fun getFirstTitle(): String

    suspend fun getSecondTitle(): String
}