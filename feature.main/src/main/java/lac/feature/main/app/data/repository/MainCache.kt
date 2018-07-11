package lac.feature.main.app.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider

interface MainCache{
    fun putBookmarks(bookmarks:List<DataBookmark>): Completable
    fun getBookmarks(): Single<List<DataBookmark>>

    fun putCities(cities:List<DataCity>): Completable
    fun getCities(): Single<List<DataCity>>

    fun putProviders(providers:List<DataProvider>): Completable
    fun getProviders(): Single<List<DataProvider>>

    fun putFeeds(feeds:List<DataFeed>): Completable
    fun getFeeds(): Single<List<DataFeed>>

    fun isCached(): Boolean
    fun setLastCacheTime(lastCache: Long)
    fun isExpired(): Boolean
}