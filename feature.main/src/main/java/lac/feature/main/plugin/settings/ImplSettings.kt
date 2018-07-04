package lac.feature.main.plugin.settings

import android.content.Context
import android.content.SharedPreferences

private const val COMMON = "common"
private const val CITY_ID = "CITY_ID"
private const val IS_ENABLED_NOTIFICATION = "IS_ENABLED_NOTIFICATION"

class ImplSettings(context: Context) : Settings {

    private val sharedPrefs: SharedPreferences by lazy {
        context.getSharedPreferences(COMMON, Context.MODE_PRIVATE)
    }

    override fun isEnabledNotification(): Boolean {
        return sharedPrefs.get(IS_ENABLED_NOTIFICATION, false) as Boolean
    }

    override fun setEnabledNotification(value: Boolean) {
        sharedPrefs.add(IS_ENABLED_NOTIFICATION, value)
    }

    override fun getCityId(): Int {
        return sharedPrefs.get(CITY_ID, -1) as Int
    }

    override fun setCity(value: Int) {
        sharedPrefs.add(CITY_ID, value)
    }

    override fun setProviders(value: ArrayList<Int>) {
    }

    override fun getProviders(): ArrayList<Int> {
        return ArrayList(0)
    }

    fun SharedPreferences.add(key: String, value: Any) {
        val s = this.edit()
        when (value) {
            is Int -> s.putInt(key, value)
            is String -> s.putString(key, value)
            is Boolean -> s.putBoolean(key, value)
        }
        s.apply()
    }

    fun SharedPreferences.get(key: String, defValue: Any): Any? {
        return when (defValue) {
            is Int -> this.getInt(key, defValue)
            is String -> this.getString(key, defValue)
            is Boolean -> this.getBoolean(key, defValue)
            else -> null
        }
    }
}