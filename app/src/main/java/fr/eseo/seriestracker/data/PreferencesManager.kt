package fr.eseo.seriestracker.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("series_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_LAST_REFRESH = "last_refresh_timestamp"
    }

    fun getLastRefreshTimestamp(): Long {
        return prefs.getLong(KEY_LAST_REFRESH, 0L)
    }

    fun saveLastRefreshTimestamp(timestamp: Long) {
        val editor = prefs.edit()
        editor.putLong(KEY_LAST_REFRESH, timestamp)
        editor.apply()
    }
}
