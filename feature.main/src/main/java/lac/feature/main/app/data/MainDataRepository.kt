package lac.feature.main.app.data

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.data.mapper.DataBookmarkMapper
import lac.feature.main.app.data.mapper.DataCityMapper
import lac.feature.main.app.data.mapper.DataFeedMapper
import lac.feature.main.app.data.mapper.DataProviderMapper
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.data.source.MainDataStoreFactory
import lac.feature.main.app.data.source.MainRemoteDataStore
import lac.feature.main.app.domain.model.Bookmark
import lac.feature.main.app.domain.model.City
import lac.feature.main.app.domain.model.Feed
import lac.feature.main.app.domain.model.Provider
import lac.feature.main.app.domain.repository.MainRepository

class MainDataRepository(val factory: MainDataStoreFactory,
                         val bookmarkMapper: DataBookmarkMapper,
                         val cityMapper: DataCityMapper,
                         val feedMapper: DataFeedMapper,
                         val providerMapper: DataProviderMapper) : MainRepository {

    override fun clearBookmarks(): Completable {
        return factory.retrieveCacheDataStore()
            .clearBookmarks()
    }

    override fun saveBookmarks(bookmarks: List<Bookmark>): Completable {
        val bookmarksEntities = bookmarks.map { bookmarkMapper.mapToEntity(it) }
        return saveDataBookmarks(bookmarksEntities)
    }

    fun saveDataBookmarks(bookmarks: List<DataBookmark>): Completable {
        return factory.retrieveCacheDataStore()
            .saveBookmarks(bookmarks)
    }

    override fun getBookmarks(): Single<List<Bookmark>> {
        val dataStore = factory.retrieveDataStoreCities()
        return dataStore.getBookmarks()
            .flatMap {
                if (dataStore is MainRemoteDataStore) {
                    saveDataBookmarks(it).toSingle { it }
                } else {
                    Single.just(it)
                }
            }
            .map { list ->
                list.map { listItem ->
                    bookmarkMapper.mapFromEntity(listItem)
                }
            }
    }

    override fun clearCities(): Completable {
        return factory.retrieveCacheDataStore()
            .clearCities()
    }

    override fun saveCities(cities: List<City>): Completable {
        val citiesEntities = cities.map { cityMapper.mapToEntity(it) }
        return saveDataCities(citiesEntities)
    }

    fun saveDataCities(cities: List<DataCity>): Completable {
        return factory.retrieveCacheDataStore()
            .saveCities(cities)
    }

    override fun getCities(): Single<List<City>> {
        val dataStore = factory.retrieveDataStoreCities()
        return dataStore.getCities()
            .flatMap {
                if (dataStore is MainRemoteDataStore) {
                    saveDataCities(it).toSingle { it }
                } else {
                    Single.just(it)
                }
            }
            .map { list ->
                list.map { listItem ->
                    cityMapper.mapFromEntity(listItem)
                }
            }
    }

    override fun clearProviders(): Completable {
        return factory.retrieveCacheDataStore()
            .clearProviders()
    }

    override fun saveProviders(providers: List<Provider>): Completable {
        val providersEntities = providers.map { providerMapper.mapToEntity(it) }
        return saveDataProviders(providersEntities)
    }

    fun saveDataProviders(providers: List<DataProvider>): Completable {
        return factory.retrieveCacheDataStore()
            .saveProviders(providers)
    }

    override fun getProviders(): Single<List<Provider>> {
        val dataStore = factory.retrieveDataStoreCities()
        return dataStore.getProviders()
            .flatMap {
                if (dataStore is MainRemoteDataStore) {
                    saveDataProviders(it).toSingle { it }
                } else {
                    Single.just(it)
                }
            }
            .map { list ->
                list.map { listItem ->
                    providerMapper.mapFromEntity(listItem)
                }
            }
    }

    override fun clearFeed(): Completable {
        return factory.retrieveCacheDataStore()
            .clearFeeds()
    }

    override fun saveFeed(feeds: List<Feed>): Completable {
        val feedsEntities = feeds.map { feedMapper.mapToEntity(it) }
        return saveDataFeeds(feedsEntities)
    }

    fun saveDataFeeds(feeds: List<DataFeed>): Completable {
        return factory.retrieveCacheDataStore()
            .saveFeeds(feeds)
    }

    override fun getFeed(): Single<List<Feed>> {
        val dataStore = factory.retrieveDataStoreCities()
        return dataStore.getFeeds()
            .flatMap {
                if (dataStore is MainRemoteDataStore) {
                    saveDataFeeds(it).toSingle { it }
                } else {
                    Single.just(it)
                }
            }
            .map { list ->
                list.map { listItem ->
                    feedMapper.mapFromEntity(listItem)
                }
            }
    }
}