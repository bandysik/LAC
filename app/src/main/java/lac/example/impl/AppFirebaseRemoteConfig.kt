package lac.example.impl

import android.app.Activity
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import lac.plugin.remoteconfig.RemoteConfig

class AppFirebaseRemoteConfig : RemoteConfig {
    private val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    override fun fetch(activity: Activity, onLoaded: () -> Unit) {
// cacheExpirationSeconds is set to cacheExpiration here, indicating the next fetch request
// will use fetch data from the Remote Config service, rather than cached parameter values,
// if cached parameter values are more than cacheExpiration seconds old.
// See Best Practices in the README for more information.
        val fetch = mFirebaseRemoteConfig.fetch(0L)
        fetch.addOnCompleteListener(activity) { task ->
            if (task.isSuccessful) {
                Toast.makeText(activity, "Fetch Succeeded", Toast.LENGTH_SHORT)
                    .show()

                // After config data is successfully fetched, it must be activated before newly fetched
                // values are returned.
                mFirebaseRemoteConfig.activateFetched()
            } else {
                Toast.makeText(activity, "Fetch Failed", Toast.LENGTH_SHORT)
                    .show()
            }
            onLoaded()
        }
    }

    override fun isEnabledPro(): Boolean {
        return mFirebaseRemoteConfig.getBoolean("isEnabledPro")
    }
}