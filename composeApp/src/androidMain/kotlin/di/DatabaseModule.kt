package di

import database.AppDatabase
import database.DBFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val provideDatabaseModule = module {
    single<AppDatabase> { DBFactory(androidContext()).createDatabase() }
}