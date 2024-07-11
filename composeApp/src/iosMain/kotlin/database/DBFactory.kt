package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

actual class DBFactory(){
    actual fun createDatabase() : AppDatabase{
        val dbFile = NSHomeDirectory() + DB_FILE_NAME
        return Room.databaseBuilder<AppDatabase>(dbFile, factory = {
            AppDatabase::class.instantiateImpl()
        })
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}