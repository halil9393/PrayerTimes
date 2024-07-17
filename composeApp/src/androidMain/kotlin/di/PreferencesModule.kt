package di

import database.AppDatabase
import database.DBFactory
import database.PreferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


actual val providePreferencesModule = module {
    single<PreferencesDataStore> { PreferencesDataStore(get()) }
}