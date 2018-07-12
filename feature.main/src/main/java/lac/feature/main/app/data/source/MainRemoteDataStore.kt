package lac.feature.main.app.data.source

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.data.repository.MainDataStore
import lac.feature.main.app.data.repository.MainRemote

class MainRemoteDataStore(val mainRemote: MainRemote) : MainDataStore {
    override fun clearBookmarks(): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearCities(): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearProviders(): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearFeeds(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBookmarks(bookmarks: List<DataBookmark>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getBookmarks(): Single<List<DataBookmark>> {
        return mainRemote.getBookmarks()
    }

    override fun saveCities(cities: List<DataCity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getCities(): Single<List<DataCity>> {
        return mainRemote.getCities()
    }

    override fun saveProviders(providers: List<DataProvider>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getProviders(): Single<List<DataProvider>> {
        return mainRemote.getProviders()
    }

    override fun saveFeeds(feeds: List<DataFeed>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        return mainRemote.getFeeds()
    }
}