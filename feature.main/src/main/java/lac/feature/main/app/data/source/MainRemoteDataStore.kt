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
    override fun putBookmarks(bookmarks: List<DataBookmark>): Completable {
        return mainRemote.putBookmarks(bookmarks)
    }

    override fun getBookmarks(): Single<List<DataBookmark>> {
        return mainRemote.getBookmarks()
    }

    override fun putCities(cities: List<DataCity>): Completable {
        return mainRemote.putCities(cities)
    }

    override fun getCities(): Single<List<DataCity>> {
        return mainRemote.getCities()
    }

    override fun putProviders(providers: List<DataProvider>): Completable {
        return mainRemote.putProviders(providers)
    }

    override fun getProviders(): Single<List<DataProvider>> {
        return mainRemote.getProviders()
    }

    override fun putFeeds(feeds: List<DataFeed>): Completable {
        return mainRemote.putFeeds(feeds)
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        return mainRemote.getFeeds()
    }
}