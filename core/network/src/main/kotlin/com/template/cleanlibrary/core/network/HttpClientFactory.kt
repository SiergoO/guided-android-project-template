package com.template.cleanlibrary.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import timber.log.Timber

class HttpClientFactory {

    @OptIn(ExperimentalSerializationApi::class)
    fun createHttpClient(): HttpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(
                Json {
                    explicitNulls = false
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

        HttpResponseValidator {
            validateResponse { response ->
                when {
                    response.status.isSuccess() -> Timber.d("Successful API request with status code ${response.status.value}")
                    else -> Timber.e("API request ended with an error with status code ${response.status.value}")
                }
            }
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 20_000
            socketTimeoutMillis = requestTimeoutMillis
            connectTimeoutMillis = requestTimeoutMillis
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    if (message.isNotEmpty()) {
                        this@HttpClientFactory.apply {
                            Timber.d(message)
                        }
                    }
                }
            }
            level = LogLevel.INFO
        }
    }
}