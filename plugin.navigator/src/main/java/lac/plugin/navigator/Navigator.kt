package lac.plugin.navigator

import android.app.Activity

interface Navigator {
    companion object {
        lateinit var navigator: Navigator
    }

    fun startPro(activity: Activity)
}