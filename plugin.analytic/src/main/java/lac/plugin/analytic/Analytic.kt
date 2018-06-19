package lac.plugin.analytic

import android.os.Bundle

interface Analytic {
    fun event(keyEvent: String, bundle: Bundle)
    fun eventOpenHome()
    fun eventOpenBookmarks()
    fun eventOpenSettings()
}