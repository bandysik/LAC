package lac.plugin.analytic

import android.os.Bundle

interface Analytic {
    companion object {
        lateinit var analytic: Analytic
    }

    fun event(keyEvent: String, bundle: Bundle)
    fun eventOpenHome()
    fun eventOpenBookmarks()
    fun eventOpenSettings()
}