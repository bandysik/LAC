package lac.plugin.remoteconfig

interface RemoteConfig {
    fun fetch(onLoaded: () -> Unit)
    fun isEnabledPro(): Boolean
}