package di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import repository.NetworkRepository

val provideRepositoryModule = module {
    single<NetworkRepository> { NetworkRepository(get(named("EzanVaktiApiClient"))) }
}