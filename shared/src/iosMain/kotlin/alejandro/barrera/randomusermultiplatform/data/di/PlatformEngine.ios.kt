package alejandro.barrera.randomusermultiplatform.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

actual val networkModule = module {
    single {
        HttpClient(Darwin) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            install(HttpTimeout) {
                requestTimeoutMillis   = 15_000
                connectTimeoutMillis   = 10_000
                socketTimeoutMillis    = 15_000
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level  = LogLevel.ALL
            }
            engine {
                configureSession {
                    waitsForConnectivity = true
                    allowsCellularAccess = true
                    timeoutIntervalForRequest = 15.0
                }
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
        }
    }
}