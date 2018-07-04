package lac.feature.main.plugin.settings

import java.util.*

interface Settings {
    fun isEnabledNotification(): Boolean
    fun setEnabledNotification(value: Boolean)

    fun getCityId(): Int
    fun setCity(value: Int)

    fun setProviders(value: ArrayList<Int>)
    fun getProviders(): ArrayList<Int>
}