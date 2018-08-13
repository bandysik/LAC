package lac.feature.main

import lac.core.feature.core.utils.rx.ApplicationSchedulerProvider
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.app.cache.MainCacheImpl
import lac.feature.main.app.cache.PreferencesHelper
import lac.feature.main.app.cache.db.DbOpenHelper
import lac.feature.main.app.cache.db.mapper.DbBookmarkMapper
import lac.feature.main.app.cache.db.mapper.DbCityMapper
import lac.feature.main.app.cache.db.mapper.DbFeedMapper
import lac.feature.main.app.cache.db.mapper.DbProviderMapper
import lac.feature.main.app.cache.mapper.CacheBookmarkMapper
import lac.feature.main.app.cache.mapper.CacheCityMapper
import lac.feature.main.app.cache.mapper.CacheFeedMapper
import lac.feature.main.app.cache.mapper.CacheProviderMapper
import lac.feature.main.app.data.MainDataRepository
import lac.feature.main.app.data.mapper.DataBookmarkMapper
import lac.feature.main.app.data.mapper.DataCityMapper
import lac.feature.main.app.data.mapper.DataFeedMapper
import lac.feature.main.app.data.mapper.DataProviderMapper
import lac.feature.main.app.data.repository.MainCache
import lac.feature.main.app.data.repository.MainRemote
import lac.feature.main.app.data.source.MainCacheDataStore
import lac.feature.main.app.data.source.MainDataStoreFactory
import lac.feature.main.app.data.source.MainRemoteDataStore
import lac.feature.main.app.domain.repository.MainRepository
import lac.feature.main.app.mobile.bookmarks.bookmarksSubModule
import lac.feature.main.app.mobile.detail.detailSubModule
import lac.feature.main.app.mobile.feed.feedSubModule
import lac.feature.main.app.mobile.home.homeSubModule
import lac.feature.main.app.mobile.notification.notificationSubModule
import lac.feature.main.app.mobile.settings.city.cityDialogSubModule
import lac.feature.main.app.mobile.settings.provider.providerDialogSubModule
import lac.feature.main.app.mobile.settings.settingsSubModule
import lac.feature.main.app.remote.MainRemoteImpl
import lac.feature.main.app.remote.MainServiceFactory
import lac.feature.main.app.remote.mapper.RemoteCityMapper
import lac.feature.main.app.remote.mapper.RemoteFeedMapper
import lac.feature.main.app.remote.mapper.RemoteProviderMapper
import lac.plugin.analytic.Analytic
import lac.plugin.remoteconfig.RemoteConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object MainModule {

    val mainModule = applicationContext {
//        bean { StubRepository() as Repository }
        bean { RemoteConfig.remoteConfig }
        bean { Analytic.analytic }
        bean { ApplicationSchedulerProvider() as SchedulerProvider }
        bean { PreferencesHelper(androidApplication()) }
        bean {
            MainCacheImpl(DbOpenHelper(androidApplication()),
                          DbBookmarkMapper(),
                          CacheBookmarkMapper(),
                          DbCityMapper(),
                          CacheCityMapper(),
                          DbFeedMapper(),
                          CacheFeedMapper(),
                          DbProviderMapper(),
                          CacheProviderMapper(),
                          get()) as MainCache
        }
        bean {
            MainRemoteImpl(MainServiceFactory.makeMainService(BuildConfig.DEBUG),
                           RemoteCityMapper(),
                           RemoteFeedMapper(),
                           RemoteProviderMapper()) as MainRemote
        }
        bean {
            MainDataRepository(MainDataStoreFactory(get(),
                                                    MainCacheDataStore(get()),
                                                    MainRemoteDataStore(get())),
                               DataBookmarkMapper(),
                               DataCityMapper(),
                               DataFeedMapper(),
                               DataProviderMapper()) as MainRepository
        }
    }

    fun init(): List<Module> {
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