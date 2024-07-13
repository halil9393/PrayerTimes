package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSSearchPathDomainMask
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

actual class DBFactory(){


    /*actual fun createDatabase() : AppDatabase{
        val dbFile = NSHomeDirectory() + DB_FILE_NAME
        return Room.databaseBuilder<AppDatabase>(dbFile, factory = {
            AppDatabase::class.instantiateImpl()
        })
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }*/

    actual fun createDatabase(): AppDatabase {
        val dbFile = fileDirectory() + DB_FILE_NAME
        return Room.databaseBuilder<AppDatabase>(dbFile, factory = {
            AppDatabase::class.instantiateImpl()
        })
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }


    // NSHomeDirectory cauases temporary files. So i migrated to NSFileManager
    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory).path!!
    }
}