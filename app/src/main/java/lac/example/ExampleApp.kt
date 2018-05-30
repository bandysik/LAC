package lac.example

import lac.core.app.LacApplication
import lac.plugin.logger.loggerModule
import org.koin.android.ext.android.startKoin

class ExampleApp : LacApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(loggerModule))
    }
}