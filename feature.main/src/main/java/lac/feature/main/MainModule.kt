package lac.feature.main

import android.app.Application
import lac.feature.main.app.bookmarks.bookmarksSubModule
import lac.feature.main.app.detail.detailSubModule
import lac.feature.main.app.feed.feedSubModule
import lac.feature.main.app.home.homeSubModule
import lac.feature.main.app.notification.notificationSubModule
import lac.feature.main.app.settings.city.cityDialogSubModule
import lac.feature.main.app.settings.provider.providerDialogSubModule
import lac.feature.main.app.settings.settingsSubModule
import lac.feature.main.data.Repository
import lac.feature.main.data.StubRepository
import lac.feature.main.plugin.settings.MainSettings
import lac.feature.main.plugin.settings.ImplSettings
import lac.plugin.analytic.ImplAnalytic
import lac.plugin.remoteconfig.ImplRemoteConfig
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.applicationContext

object MainModule {

    val mainModule = applicationContext {
        bean { StubRepository() as Repository }
        bean { ImplRemoteConfig.remoteConfig }
        bean { MainSettings.settings }
        bean { ImplAnalytic.analytic }
//        bean { StubRepository() as Repository }//TODO retrofit
//        bean { StubRepository() as Repository }//TODO database
    }

    fun init(app: Application) {
        MainSettings.settings = ImplSettings(app)

        app.startKoin(app,
                      listOf(mainModule,
                             bookmarksSubModule,
                             detailSubModule,
                             feedSubModule,
                             homeSubModule,
                             notificationSubModule,
                             settingsSubModule,
                             providerDialogSubModule,
                             cityDialogSubModule))
    }
}