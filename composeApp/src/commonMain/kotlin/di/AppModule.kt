package di

import org.koin.core.KoinApplication

fun appModule() = listOf(
    providehttpClientModule,
    provideRepositoryModule,
    provideviewModelModule,
    provideDatabaseModule,
    providePreferencesModule
)