package lac.example.impl

import lac.plugin.remoteconfig.RemoteConfig

object AppRemoteConfig : RemoteConfig {
    override fun isEnabledPro(): Boolean {
        return true
    }

}