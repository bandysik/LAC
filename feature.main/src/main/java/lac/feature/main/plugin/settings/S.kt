package lac.feature.main.plugin.settings

import android.content.Context
import android.content.SharedPreferences

private const val IS_ENABLED_NOTIFICATION = "IS_ENABLED_NOTIFICATION"

class S(context: Context) : Settings {

    private var sharedPrefs: SharedPreferences = context.getSharedPreferences("common", Context.MODE_PRIVATE)

    override fun isEnabledNotification(): Boolean {
        return sharedPrefs.getBoolean(IS_ENABLED_NOTIFICATION, false)
    }

    override fun setEnabledNotification(value: Boolean) {
        sharedPrefs.edit().putBoolean(IS_ENABLED_NOTIFICATION, value).apply()
    }
}