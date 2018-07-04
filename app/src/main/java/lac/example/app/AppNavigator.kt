package lac.example.app

import android.app.Activity
import android.content.Intent
import lac.feature.additional.pro.ProActivity
import lac.plugin.navigator.Navigator

object AppNavigator : Navigator {
    override fun startPro(activity: Activity) {
        val intent = Intent(activity, ProActivity::class.java)
        activity.startActivity(intent)
    }
}