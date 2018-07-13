package lac.feature.main.app.cache

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {
    companion object {
        private val PREF_MAIN_PACKAGE_NAME = "org.buffer.android.boilerplate.preferences"

        private val PREF_KEY_LAST_CACHE_BOOKMARKS = "last_cache_bookmarks"
        private val PREF_KEY_LAST_CACHE_CITIES = "last_cache_cities"
        private val PREF_KEY_LAST_CACHE_PROVIDERS = "last_cache_providers"
        private val PREF_KEY_LAST_CACHE_FEEDS = "last_cache_feeds"

        private val PREF_KEY_PROVIDERS = "pref_key_providers"
        private val PREF_KEY_CITY_ID = "pref_key_city_id"
        private val PREF_KEY_IS_ENABLED_NOTIFICATION = "pref_key_is_enabled_notification"
    }

    private val mainPref: SharedPreferences

    init {
        mainPref = context.getSharedPreferences(PREF_MAIN_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTimeBookmarks: Long
        get() = mainPref.getLong(PREF_KEY_LAST_CACHE_BOOKMARKS, 0)
        set(lastCache) = mainPref.edit().putLong(PREF_KEY_LAST_CACHE_BOOKMARKS, lastCache).apply()

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTimeCities: Long
        get() = mainPref.getLong(PREF_KEY_LAST_CACHE_CITIES, 0)
        set(lastCache) = mainPref.edit().putLong(PREF_KEY_LAST_CACHE_CITIES, lastCache).apply()

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTimeFeeds: Long
        get() = mainPref.getLong(PREF_KEY_LAST_CACHE_FEEDS, 0)
        set(lastCache) = mainPref.edit().putLong(PREF_KEY_LAST_CACHE_FEEDS, lastCache).apply()

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTimeProviders: Long
        get() = mainPref.getLong(PREF_KEY_LAST_CACHE_PROVIDERS, 0)
        set(lastCache) = mainPref.edit().putLong(PREF_KEY_LAST_CACHE_PROVIDERS, lastCache).apply()

    var isEnabledNotification: Boolean
        get() = mainPref.getBoolean(PREF_KEY_IS_ENABLED_NOTIFICATION, false)
        set(isEnabled) = mainPref.edit().putBoolean(PREF_KEY_IS_ENABLED_NOTIFICATION,
                                                    isEnabled).apply()

    var cityId: Int
        get() = mainPref.getInt(PREF_KEY_CITY_ID, -1)
        set(cityId) = mainPref.edit().putInt(PREF_KEY_CITY_ID, cityId).apply()

    var providers: Set<String>
        get() = mainPref.getStringSet(PREF_KEY_PROVIDERS, emptySet())
        set(providers) = mainPref.edit().putStringSet(PREF_KEY_PROVIDERS, providers).apply()
}