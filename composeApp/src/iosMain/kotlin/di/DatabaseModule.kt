package di

import database.AppDatabase
import database.DBFactory
import org.koin.dsl.module

actual val provideDatabaseModule = module {
    single<AppDatabase> { DBFactory().createDatabase() }
}