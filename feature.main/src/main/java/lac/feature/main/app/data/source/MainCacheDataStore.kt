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
    override fun putBookmarks(bookmarks: List<DataBookmark>): Completable {
        return mainCache.putBookmarks(bookmarks)
    }

    override fun getBookmarks(): Single<List<DataBookmark>> {
        return mainCache.getBookmarks()
    }

    override fun putCities(cities: List<DataCity>): Completable {
        return mainCache.putCities(cities)
    }

    override fun getCities(): Single<List<DataCity>> {
        return mainCache.getCities()
    }

    override fun putProviders(providers: List<DataProvider>): Completable {
        return mainCache.putProviders(providers)
    }

    override fun getProviders(): Single<List<DataProvider>> {
        return mainCache.getProviders()
    }

    override fun putFeeds(feeds: List<DataFeed>): Completable {
        return mainCache.putFeeds(feeds)
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        return mainCache.getFeeds()
    }
}