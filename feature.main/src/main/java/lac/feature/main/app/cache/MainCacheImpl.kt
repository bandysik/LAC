package lac.feature.main.app.cache

import android.database.sqlite.SQLiteDatabase
import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.cache.db.Db
import lac.feature.main.app.cache.db.DbOpenHelper
import lac.feature.main.app.cache.db.MainConstants
import lac.feature.main.app.cache.db.mapper.DbBookmarkMapper
import lac.feature.main.app.cache.db.mapper.DbCityMapper
import lac.feature.main.app.cache.db.mapper.DbFeedMapper
import lac.feature.main.app.cache.db.mapper.DbProviderMapper
import lac.feature.main.app.cache.mapper.CacheBookmarkMapper
import lac.feature.main.app.cache.mapper.CacheCityMapper
import lac.feature.main.app.cache.mapper.CacheFeedMapper
import lac.feature.main.app.cache.mapper.CacheProviderMapper
import lac.feature.main.app.cache.model.CacheBookmark
import lac.feature.main.app.cache.model.CacheCity
import lac.feature.main.app.cache.model.CacheFeed
import lac.feature.main.app.cache.model.CacheProvider
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.data.repository.MainCache

class MainCacheImpl(dbOpenHelper: DbOpenHelper,
                    private val dbBookmarkMapper: DbBookmarkMapper,
                    private val cacheBookmarkMapper: CacheBookmarkMapper,
                    private val dbCityMapper: DbCityMapper,
                    private val cacheCityMapper: CacheCityMapper,
                    private val dbFeedMapper: DbFeedMapper,
                    private val cacheFeedMapper: CacheFeedMapper,
                    private val dbProviderMapper: DbProviderMapper,
                    private val cacheProviderMapper: CacheProviderMapper,
                    private val preferencesHelper: PreferencesHelper) : MainCache {

    private val EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    private var database: SQLiteDatabase = dbOpenHelper.writableDatabase

    /**
     * Retrieve an instance from the database, used for tests
     */
    internal fun getDatabase(): SQLiteDatabase {
        return database
    }

    override fun clearBookmarks(): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                database.delete(Db.BookmarkTable.TABLE_NAME, null, null)
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun saveBookmark(bookmark: DataBookmark): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                saveBookmark(cacheBookmarkMapper.mapToCached(bookmark))
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun getBookmarks(): Single<List<DataBookmark>> {
        return Single.defer<List<DataBookmark>> {
            val updatesCursor = database.rawQuery(MainConstants.QUERY_GET_ALL_BOOKMARKS, null)
            val bookmarks = mutableListOf<DataBookmark>()

            while (updatesCursor.moveToNext()) {
                val cachedBookmark = dbBookmarkMapper.parseCursor(updatesCursor)
                bookmarks.add(cacheBookmarkMapper.mapFromCached(cachedBookmark))
            }

            updatesCursor.close()
            Single.just<List<DataBookmark>>(bookmarks)
        }
    }

    private fun saveBookmark(bookmark: CacheBookmark) {
        val u = database.update(Db.BookmarkTable.TABLE_NAME, dbBookmarkMapper.toContentValues(bookmark), "${Db.BookmarkTable.BOOKMARK_ID}=?", arrayOf(bookmark.id))
        if (u == 0) {
            database.insertWithOnConflict(Db.BookmarkTable.TABLE_NAME, null, dbBookmarkMapper.toContentValues(bookmark), SQLiteDatabase.CONFLICT_REPLACE)
        }
    }

    override fun isCachedBookmarks(): Boolean {
        return database.rawQuery(MainConstants.QUERY_GET_ALL_BOOKMARKS, null).count > 0
    }

    override fun setLastCacheTimeBookmarks(lastCache: Long) {
        preferencesHelper.lastCacheTimeBookmarks = lastCache
    }

    override fun isExpiredBookmarks(): Boolean {
        return isExpired(this.getLastCacheUpdateBookmarksTimeMillis())
    }

    private fun getLastCacheUpdateBookmarksTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeBookmarks
    }

    override fun clearCities(): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                database.delete(Db.CitiesTable.TABLE_NAME, null, null)
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun saveCities(cities: List<DataCity>): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                cities.forEach {
                    saveCity(cacheCityMapper.mapToCached(it))
                }
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    private fun saveCity(city: CacheCity) {
        val u = database.update(Db.CitiesTable.TABLE_NAME, dbCityMapper.toContentValues(city), "${Db.CitiesTable.CITY_ID}=?", arrayOf(city.id))
        if (u == 0) {
            database.insertWithOnConflict(Db.CitiesTable.TABLE_NAME, null, dbCityMapper.toContentValues(city), SQLiteDatabase.CONFLICT_REPLACE)
        }
    }

    override fun getCities(): Single<List<DataCity>> {
        return Single.defer<List<DataCity>> {
            val updatesCursor = database.rawQuery(MainConstants.QUERY_GET_ALL_CITIES, null)
            val cities = mutableListOf<DataCity>()

            while (updatesCursor.moveToNext()) {
                val cachedCity = dbCityMapper.parseCursor(updatesCursor)
                cities.add(cacheCityMapper.mapFromCached(cachedCity))
            }

            updatesCursor.close()
            Single.just<List<DataCity>>(cities)
        }
    }

    override fun isCachedCities(): Boolean {
        return database.rawQuery(MainConstants.QUERY_GET_ALL_CITIES, null).count > 0
    }

    override fun setLastCacheTimeCities(lastCache: Long) {
        preferencesHelper.lastCacheTimeCities = lastCache
    }

    override fun isExpiredCities(): Boolean {
        return isExpired(this.getLastCacheUpdateCitiesTimeMillis())
    }

    override fun clearProviders(): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                database.delete(Db.ProvidersTable.TABLE_NAME, null, null)
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun saveProviders(providers: List<DataProvider>): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                providers.forEach {
                    saveProvider(cacheProviderMapper.mapToCached(it))
                }
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    private fun saveProvider(provider: CacheProvider) {
        val u = database.update(Db.ProvidersTable.TABLE_NAME, dbProviderMapper.toContentValues(provider), "${Db.ProvidersTable.PROVIDER_ID}=?", arrayOf(provider.id))
        if (u == 0) {
            database.insertWithOnConflict(Db.ProvidersTable.TABLE_NAME, null, dbProviderMapper.toContentValues(provider), SQLiteDatabase.CONFLICT_REPLACE)
        }
    }

    override fun getProviders(): Single<List<DataProvider>> {
        return Single.defer<List<DataProvider>> {
            val updatesCursor = database.rawQuery(MainConstants.QUERY_GET_ALL_PROVIDERS, null)
            val providers = mutableListOf<DataProvider>()

            while (updatesCursor.moveToNext()) {
                val cachedProvider = dbProviderMapper.parseCursor(updatesCursor)
                providers.add(cacheProviderMapper.mapFromCached(cachedProvider))
            }

            updatesCursor.close()
            Single.just<List<DataProvider>>(providers)
        }
    }

    override fun isCachedProviders(): Boolean {
        return database.rawQuery(MainConstants.QUERY_GET_ALL_PROVIDERS, null).count > 0
    }

    override fun setLastCacheTimeProviders(lastCache: Long) {
        preferencesHelper.lastCacheTimeProviders = lastCache
    }

    override fun isExpiredProviders(): Boolean {
        return isExpired(this.getLastCacheUpdateProvidersTimeMillis())
    }

    override fun clearFeeds(): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                database.delete(Db.FeedsTable.TABLE_NAME, null, null)
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    override fun saveFeeds(feeds: List<DataFeed>): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                feeds.forEach {
                    saveFeed(cacheFeedMapper.mapToCached(it))
                }
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    private fun saveFeed(feed: CacheFeed) {
        val u = database.update(Db.FeedsTable.TABLE_NAME, dbFeedMapper.toContentValues(feed), "${Db.FeedsTable.FEED_ID}=?", arrayOf(feed.id))
        if (u == 0) {
            database.insertWithOnConflict(Db.FeedsTable.TABLE_NAME, null, dbFeedMapper.toContentValues(feed), SQLiteDatabase.CONFLICT_REPLACE)
        }
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        return Single.defer<List<DataFeed>> {
            val updatesCursor = database.rawQuery(MainConstants.QUERY_GET_ALL_FEEDS, null)
            val feeds = mutableListOf<DataFeed>()

            while (updatesCursor.moveToNext()) {
                val cachedFeed = dbFeedMapper.parseCursor(updatesCursor)
                feeds.add(cacheFeedMapper.mapFromCached(cachedFeed))
            }

            updatesCursor.close()
            Single.just<List<DataFeed>>(feeds)
        }
    }

    override fun getFeedById(feedId: String): Single<DataFeed> {
        return Single.defer<DataFeed> {
            val updatesCursor = database.rawQuery(MainConstants.QUERY_GET_FEED_BY_ID, arrayOf(feedId))
            var feed: DataFeed? = null

            while (updatesCursor.moveToNext()) {
                val cachedFeed = dbFeedMapper.parseCursor(updatesCursor)
                feed = cacheFeedMapper.mapFromCached(cachedFeed)
            }

            updatesCursor.close()
            Single.just<DataFeed>(feed)
        }
    }

    override fun isCachedFeeds(): Boolean {
        return database.rawQuery(MainConstants.QUERY_GET_ALL_FEEDS, null).count > 0
    }

    override fun setLastCacheTimeFeeds(lastCache: Long) {
        preferencesHelper.lastCacheTimeFeeds = lastCache
    }

    override fun isExpiredFeeds(): Boolean {
        return isExpired(this.getLastCacheUpdateFeedsTimeMillis())
    }

    private fun getLastCacheUpdateFeedsTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeFeeds
    }

    private fun getLastCacheUpdateCitiesTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeCities
    }

    private fun getLastCacheUpdateProvidersTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeProviders
    }

    private fun isExpired(lastUpdateTime: Long): Boolean {
        val currentTime = System.currentTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }
}