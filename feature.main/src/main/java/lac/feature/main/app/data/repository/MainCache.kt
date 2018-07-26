package lac.feature.main.app.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider

interface MainCache{
    fun clearBookmarks(): Completable
    fun saveBookmark(bookmark:DataBookmark): Completable
    fun getBookmarks(): Single<List<DataBookmark>>
    fun isCachedBookmarks(): Boolean
    fun setLastCacheTimeBookmarks(lastCache: Long)
    fun isExpiredBookmarks(): Boolean

    fun clearCities(): Completable
    fun saveCities(cities:List<DataCity>): Completable
    fun getCities(): Single<List<DataCity>>
    fun isCachedCities(): Boolean
    fun setLastCacheTimeCities(lastCache: Long)
    fun isExpiredCities(): Boolean

    fun clearProviders(): Completable
    fun saveProviders(providers:List<DataProvider>): Completable
    fun getProviders(): Single<List<DataProvider>>
    fun isCachedProviders(): Boolean
    fun setLastCacheTimeProviders(lastCache: Long)
    fun isExpiredProviders(): Boolean

    fun clearFeeds(): Completable
    fun saveFeeds(feeds:List<DataFeed>): Completable
    fun getFeeds(): Single<List<DataFeed>>
    fun isCachedFeeds(): Boolean
    fun setLastCacheTimeFeeds(lastCache: Long)
    fun isExpiredFeeds(): Boolean
    fun getFeedById(feedId: String): Single<DataFeed>
}