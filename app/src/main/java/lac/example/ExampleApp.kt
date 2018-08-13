package lac.example

import com.crashlytics.android.Crashlytics
import com.squareup.leakcanary.LeakCanary
import io.fabric.sdk.android.Fabric
import lac.core.app.LacApplication
import lac.example.app.AppFirebaseAnalytic
import lac.example.app.AppFirebaseRemoteConfig
import lac.example.app.AppImageLoader
import lac.example.app.AppNavigator
import lac.feature.additional.AdditionalModule
import lac.feature.main.MainModule
import lac.plugin.analytic.Analytic
import lac.plugin.imageloader.ImageLoader
import lac.plugin.navigator.Navigator
import lac.plugin.remoteconfig.RemoteConfig
import org.koin.android.ext.android.startKoin

class ExampleApp : LacApplication() {

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
        Navigator.navigator = AppNavigator
        RemoteConfig.remoteConfig = AppFirebaseRemoteConfig()
        Analytic.analytic = AppFirebaseAnalytic(this)
        ImageLoader.analytic = AppImageLoader
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

}