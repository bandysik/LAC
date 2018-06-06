package lac.example.impl

import android.content.Intent
import lac.example.ExampleApp
import lac.feature.additional.pro.ProActivity
import lac.plugin.navigator.Navigator

object AppNavigator : Navigator {
    override fun startPro() {
        val context = ExampleApp.applicationContext()
        val startActivity = Intent()
        startActivity.setClass(context, ProActivity::class.java)
        startActivity.action = ProActivity::class.java.name
        startActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        context.startActivity(startActivity)
    }
}