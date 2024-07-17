package di

import database.AppDatabase
import database.MDayDao
import database.PreferencesDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module
import repository.NetworkRepository

val provideRepositoryModule = module {
    single<NetworkRepository> { NetworkRepository(get(named("EzanVaktiApiClient")),get<MDayDao>(),get<PreferencesDataStore>()) }
}