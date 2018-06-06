package lac.example

import android.content.Context
import lac.core.app.LacApplication
import lac.example.impl.AppNavigator
import lac.plugin.navigator.N

class ExampleApp : LacApplication() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        N.navigator = AppNavigator
    }

    companion object {
        private var instance: ExampleApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}