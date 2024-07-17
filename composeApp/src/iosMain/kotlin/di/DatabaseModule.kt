package di

import database.AppDatabase
import database.DBFactory
import database.MDayDao
import org.koin.dsl.module

actual val provideDatabaseModule = module {
    single<AppDatabase> { DBFactory().createDatabase() }
    single<MDayDao> { get<AppDatabase>().getDao() }
}