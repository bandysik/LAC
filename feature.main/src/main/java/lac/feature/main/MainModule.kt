package lac.feature.main

import android.app.Application
import lac.feature.main.app.home.homeModule
import org.koin.android.ext.android.startKoin

object MainModule {

    fun init(app: Application) {
        app.startKoin(app, listOf(homeModule))
    }

}