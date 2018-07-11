package lac.feature.main.app.data.source

import lac.feature.main.app.data.repository.MainCache
import lac.feature.main.app.data.repository.MainDataStore

class MainDataStoreFactory(val mainCache: MainCache,
                           val mainCacheDataStore: MainCacheDataStore,
                           val mainRemoteDataStore: MainRemoteDataStore) {

    fun retrieveDataStore(): MainDataStore {
        if (mainCache.isCached() && !mainCache.isExpired()) {
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