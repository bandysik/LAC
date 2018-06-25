package lac.core.feature.core.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager

object Connectivity {
    val intentFilter: IntentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

    fun getBroadcastReceiver(onDisconnected: () -> Unit, onConnected: () -> Unit) =
            object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    val notConnected =
                            intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
                    if (notConnected) {
                        onDisconnected()
                    } else {
                        onConnected()
                    }
                }
            }
}