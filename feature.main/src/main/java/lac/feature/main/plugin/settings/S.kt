package lac.feature.main.plugin.settings

import android.content.Context
import android.content.SharedPreferences

private const val COMMON = "common"
private const val CITY_ID = "CITY_ID"
private const val IS_ENABLED_NOTIFICATION = "IS_ENABLED_NOTIFICATION"

class S(context: Context) : Settings {

    private var sharedPrefs: SharedPreferences =
            context.getSharedPreferences(COMMON, Context.MODE_PRIVATE)

    override fun isEnabledNotification(): Boolean {
        return sharedPrefs.getBoolean(IS_ENABLED_NOTIFICATION, false)
    }

    override fun setEnabledNotification(value: Boolean) {
        sharedPrefs.edit()
            .putBoolean(IS_ENABLED_NOTIFICATION, value)
            .apply()
    }

    override fun getCityId(): Int {
        return sharedPrefs.getInt(CITY_ID, -1)
    }

    override fun setCity(value: Int) {
        sharedPrefs.edit()
            .putInt(CITY_ID, value)
            .apply()
    }
}