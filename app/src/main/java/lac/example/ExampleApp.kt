package lac.example

import android.content.Context
import com.crashlytics.android.Crashlytics
import com.squareup.leakcanary.LeakCanary
import io.fabric.sdk.android.Fabric
import lac.core.app.LacApplication
import lac.example.app.AppFirebaseAnalytic
import lac.example.app.AppFirebaseRemoteConfig
import lac.example.app.AppNavigator
import lac.feature.additional.AdditionalModule
import lac.feature.main.MainModule
import lac.plugin.analytic.ImplAnalytic
import lac.plugin.navigator.ImplNavigator
import lac.plugin.remoteconfig.ImplRemoteConfig
import org.koin.android.ext.android.startKoin

class ExampleApp : LacApplication() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        if (initLeakCanary()) return

        initFeatureModules()
        initPluginModules()
        initFabric()
    }

    private fun initFabric() {
        val fabric =
                Fabric.Builder(this)
                    .kits(Crashlytics())
                    .debuggable(true)           // Enables Crashlytics debugger
                    .build()
        Fabric.with(fabric)
    }

    private fun initPluginModules() {
        ImplNavigator.navigator = AppNavigator
        ImplRemoteConfig.remoteConfig = AppFirebaseRemoteConfig()
        ImplAnalytic.analytic = AppFirebaseAnalytic(this)
    }

    private fun initFeatureModules() {
        startKoin(this, MainModule.init() + AdditionalModule.init())
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