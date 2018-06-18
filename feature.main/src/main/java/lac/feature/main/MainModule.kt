package lac.feature.main

import android.app.Application
import lac.feature.main.app.bookmarks.bookmarksSubModule
import lac.feature.main.app.detail.detailSubModule
import lac.feature.main.app.feed.feedSubModule
import lac.feature.main.app.home.homeSubModule
import lac.feature.main.app.notification.notificationSubModule
import lac.feature.main.app.settings.settingsSubModule
import lac.feature.main.plugin.settings.MainSettings
import lac.feature.main.plugin.settings.S
import org.koin.android.ext.android.startKoin

object MainModule {

    fun init(app: Application) {
        MainSettings.settings = S(app)

        app.startKoin(app,
                listOf(
                        bookmarksSubModule,
                        detailSubModule,
                        feedSubModule,
                        homeSubModule,
                        notificationSubModule,
                        settingsSubModule
                ))
    }

}