package com.template.cleanlibrary.core.domain.repository

interface MainRepository {

    suspend fun getFirstTitle(): String

    suspend fun getSecondTitle(): String
}