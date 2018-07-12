package lac.feature.main.app.data.source

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.data.repository.MainCache
import lac.feature.main.app.data.repository.MainDataStore

class MainCacheDataStore(val mainCache: MainCache) : MainDataStore {
    override fun clearBookmarks(): Completable {
        return mainCache.clearBookmarks()
    }

    override fun clearCities(): Completable {
        return mainCache.clearCities()
    }

    override fun clearProviders(): Completable {
        return mainCache.clearProviders()
    }

    override fun clearFeeds(): Completable {
        return mainCache.clearFeeds()
    }

    override fun saveBookmarks(bookmarks: List<DataBookmark>): Completable {
        return mainCache.saveBookmarks(bookmarks)
            .doOnComplete {
                mainCache.setLastCacheTimeBookmarks(System.currentTimeMillis())
            }
    }

    override fun getBookmarks(): Single<List<DataBookmark>> {
        return mainCache.getBookmarks()
    }

    override fun saveCities(cities: List<DataCity>): Completable {
        return mainCache.saveCities(cities)
            .doOnComplete {
                mainCache.setLastCacheTimeCities(System.currentTimeMillis())
            }
    }

    override fun getCities(): Single<List<DataCity>> {
        return mainCache.getCities()
    }

    override fun saveProviders(providers: List<DataProvider>): Completable {
        return mainCache.saveProviders(providers)
            .doOnComplete {
                mainCache.setLastCacheTimeProviders(System.currentTimeMillis())
            }
    }

    override fun getProviders(): Single<List<DataProvider>> {
        return mainCache.getProviders()
    }

    override fun saveFeeds(feeds: List<DataFeed>): Completable {
        return mainCache.saveFeeds(feeds)
            .doOnComplete {
                mainCache.setLastCacheTimeFeeds(System.currentTimeMillis())
            }
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        return mainCache.getFeeds()
    }
}