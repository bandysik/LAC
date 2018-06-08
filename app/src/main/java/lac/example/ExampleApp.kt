package lac.example

import android.content.Context
import com.squareup.leakcanary.LeakCanary
import lac.core.app.LacApplication
import lac.example.impl.AppNavigator
import lac.feature.additional.AdditionalModule
import lac.feature.main.MainModule
import lac.plugin.navigator.N

class ExampleApp : LacApplication() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        if (initLeakCanary()) return

        MainModule.init(this)
        AdditionalModule.init(this)

        N.navigator = AppNavigator
    }

    private fun initLeakCanary(): Boolean {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return true
        }
        LeakCanary.install(this)
        return false
    }

    companion object {
        private var instance: ExampleApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}