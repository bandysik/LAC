package lac.plugin.remoteconfig

interface RemoteConfig {
    companion object {
        lateinit var remoteConfig: RemoteConfig
    }

    fun fetch(onLoaded: () -> Unit)
    fun isEnabledPro(): Boolean
}