package lac.feature.main.app.data.source

import lac.feature.main.app.data.repository.MainCache
import lac.feature.main.app.data.repository.MainDataStore

class MainDataStoreFactory(val mainCache: MainCache,
                           val mainCacheDataStore: MainCacheDataStore,
                           val mainRemoteDataStore: MainRemoteDataStore) {

    fun retrieveDataStoreCities(): MainDataStore {
        if (mainCache.isCachedCities() && !mainCache.isExpiredCities()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    fun retrieveDataStoreBookmarks(): MainDataStore {
        if (mainCache.isCachedBookmarks() && !mainCache.isExpiredBookmarks()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    fun retrieveDataStoreFeeds(): MainDataStore {
        if (mainCache.isCachedFeeds() && !mainCache.isExpiredFeeds()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    fun retrieveDataStoreProviders(): MainDataStore {
        if (mainCache.isCachedProviders() && !mainCache.isExpiredProviders()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    fun retrieveCacheDataStore(): MainDataStore {
        return mainCacheDataStore
    }

    fun retrieveRemoteDataStore(): MainDataStore {
        return mainRemoteDataStore
    }
}