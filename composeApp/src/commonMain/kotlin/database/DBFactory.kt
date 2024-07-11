package database

expect class DBFactory {
    fun createDatabase() : AppDatabase
}