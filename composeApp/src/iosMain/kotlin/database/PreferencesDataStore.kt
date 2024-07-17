package database

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import platform.Foundation.NSUserDefaults

actual class PreferencesDataStore {
    private val defaults = NSUserDefaults.standardUserDefaults

    actual fun getString(key: String, default: String?): Flow<String?> {
        val value = defaults.stringForKey(key) ?: default
        return MutableStateFlow(value)
    }

    actual suspend fun setString(key: String, value: String) {
        defaults.setObject(value, forKey = key)
    }
}