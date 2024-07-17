package database

import kotlinx.coroutines.flow.Flow

expect class PreferencesDataStore {
    fun getString(key: String, default: String?): Flow<String?>
    suspend fun setString(key: String, value: String)
}