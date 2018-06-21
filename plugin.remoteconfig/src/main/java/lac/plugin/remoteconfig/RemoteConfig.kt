package lac.plugin.remoteconfig

import android.app.Activity

interface RemoteConfig {
    fun fetch(activity: Activity, onLoaded: () -> Unit)
    fun isEnabledPro(): Boolean
}