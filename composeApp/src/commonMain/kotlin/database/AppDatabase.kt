package database

import androidx.room.Database
import androidx.room.RoomDatabase
import data.MDay

@Database(entities = [MDay::class], version = 1)
abstract class AppDatabase :RoomDatabase() , DB {
    abstract fun getDao() : MDayDao

    override fun clearAllTables() {
        super.clearAllTables()
    }

}

internal const val DB_FILE_NAME = "app_room_db.db"

interface DB {
    fun clearAllTables() {}
}