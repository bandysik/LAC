package lac.core.app

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

abstract class LacApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initLogger()

        initDi()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDi() {
        startKoin(this, listOf())
    }
}