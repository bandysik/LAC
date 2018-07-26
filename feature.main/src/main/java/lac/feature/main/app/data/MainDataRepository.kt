package lac.feature.main.app.data

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.data.mapper.DataBookmarkMapper
import lac.feature.main.app.data.mapper.DataCityMapper
import lac.feature.main.app.data.mapper.DataFeedMapper
import lac.feature.main.app.data.mapper.DataProviderMapper
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

class MainDataRepository(private val factory: MainDataStoreFactory,
                         private val bookmarkMapper: DataBookmarkMapper,
                         private val cityMapper: DataCityMapper,
                         private val feedMapper: DataFeedMapper,
                         private val providerMapper: DataProviderMapper) : MainRepository {

    override fun clearBookmarks(): Completable {
        return factory.retrieveCacheDataStore()
                .clearBookmarks()
    }

    override fun saveBookmark(bookmark: Bookmark): Completable {
        return factory.retrieveCacheDataStore()
                .saveBookmark(bookmarkMapper.mapToEntity(bookmark))
    }


    override fun getBookmarks(): Single<List<Bookmark>> {
        val dataStore = factory.retrieveDataStoreBookmarks()
        return dataStore.getBookmarks()
                .flatMap {
                    Single.just(it)
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
        val dataStore = factory.retrieveDataStoreProviders()
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
        val dataStore = factory.retrieveDataStoreFeeds()
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

    override fun getFeedById(feedId: String): Single<Feed> {
        val dataStore = factory.retrieveCacheDataStore()
        return dataStore.getFeedById(feedId)
                .flatMap {
                    Single.just(it)
                }
                .map {
                    feedMapper.mapFromEntity(it)
                }
    }
}