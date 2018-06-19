package lac.feature.main.plugin.settings

interface Settings {
    fun isEnabledNotification(): Boolean
    fun setEnabledNotification(value: Boolean)

    fun getCityId(): Int
    fun setCity(value: Int)
}