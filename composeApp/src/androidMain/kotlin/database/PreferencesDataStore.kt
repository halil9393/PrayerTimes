package database

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

actual class PreferencesDataStore(private val context: Context) {
    private val dataStore = context.dataStore

    actual fun getString(key: String, default: String?): Flow<String?> {
        val dataStoreKey = stringPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey] ?: default
        }
    }

    actual suspend fun setString(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }
}