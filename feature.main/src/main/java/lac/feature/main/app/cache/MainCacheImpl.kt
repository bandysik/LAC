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

    override fun saveBookmarks(bookmarks: List<DataBookmark>): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                bookmarks.forEach {
                    saveBookmark(cacheBookmarkMapper.mapToCached(it))
                }
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
        database.insert(Db.BookmarkTable.TABLE_NAME,
                        null,
                        dbBookmarkMapper.toContentValues(bookmark))
    }

    override fun isCachedBookmarks(): Boolean {
        return database.rawQuery(MainConstants.QUERY_GET_ALL_BOOKMARKS, null).count > 0
    }

    override fun setLastCacheTimeBookmarks(lastCache: Long) {
        preferencesHelper.lastCacheTimeBookmarks = lastCache
    }

    override fun isExpiredBookmarks(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateBookmarksTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateBookmarksTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeBookmarks
    }

    override fun clearCities(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveCities(cities: List<DataCity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getCities(): Single<List<DataCity>> {
        throw UnsupportedOperationException()
    }

    override fun isCachedCities(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setLastCacheTimeCities(lastCache: Long) {
        throw UnsupportedOperationException()
    }

    override fun isExpiredCities(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun clearProviders(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveProviders(providers: List<DataProvider>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getProviders(): Single<List<DataProvider>> {
        throw UnsupportedOperationException()
    }

    override fun isCachedProviders(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setLastCacheTimeProviders(lastCache: Long) {
        throw UnsupportedOperationException()
    }

    override fun isExpiredProviders(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun clearFeeds(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveFeeds(feeds: List<DataFeed>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        throw UnsupportedOperationException()
    }

    override fun isCachedFeeds(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setLastCacheTimeFeeds(lastCache: Long) {
        throw UnsupportedOperationException()
    }

    override fun isExpiredFeeds(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateFeedsTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
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
}