package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.EzanVaktiApiClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val providehttpClientModule = module {
    single (named("EzanVaktiApiClient")){
        EzanVaktiApiClient().client
    }
}