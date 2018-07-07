package lac.feature.main

import android.app.Application
import lac.core.feature.core.utils.rx.ApplicationSchedulerProvider
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.app.mobile.bookmarks.bookmarksSubModule
import lac.feature.main.app.mobile.detail.detailSubModule
import lac.feature.main.app.mobile.feed.feedSubModule
import lac.feature.main.app.mobile.home.homeSubModule
import lac.feature.main.app.mobile.notification.notificationSubModule
import lac.feature.main.app.mobile.settings.city.cityDialogSubModule
import lac.feature.main.app.mobile.settings.provider.providerDialogSubModule
import lac.feature.main.app.mobile.settings.settingsSubModule
import lac.feature.main.old.data.Repository
import lac.feature.main.old.data.StubRepository
import lac.feature.main.plugin.settings.ImplSettings
import lac.feature.main.plugin.settings.MainSettings
import lac.plugin.analytic.ImplAnalytic
import lac.plugin.remoteconfig.ImplRemoteConfig
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object MainModule {

    val mainModule = applicationContext {
        bean { StubRepository() as Repository }
        bean { ImplRemoteConfig.remoteConfig }
        bean { MainSettings.settings }
        bean { ImplAnalytic.analytic }
        bean { ApplicationSchedulerProvider() as SchedulerProvider }
//        bean { StubRepository() as Repository }//TODO retrofit
//        bean { StubRepository() as Repository }//TODO database
    }

    fun init(app: Application): List<Module> {
        MainSettings.settings = ImplSettings(app)

        return listOf(mainModule,
                      bookmarksSubModule,
                      detailSubModule,
                      feedSubModule,
                      homeSubModule,
                      notificationSubModule,
                      settingsSubModule,
                      providerDialogSubModule,
                      cityDialogSubModule)
    }
}