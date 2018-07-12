package lac.feature.main.app.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import lac.feature.main.app.domain.model.Bookmark
import lac.feature.main.app.domain.model.City
import lac.feature.main.app.domain.model.Feed
import lac.feature.main.app.domain.model.Provider

interface MainRepository {
    fun clearBookmarks(): Completable
    fun saveBookmarks(bookmarks: List<Bookmark>): Completable
    fun getBookmarks(): Single<List<Bookmark>>

    fun clearCities(): Completable
    fun saveCities(cities: List<City>): Completable
    fun getCities(): Single<List<City>>

    fun clearProviders(): Completable
    fun saveProviders(providers: List<Provider>): Completable
    fun getProviders(): Single<List<Provider>>

    fun clearFeed(): Completable
    fun saveFeed(feeds: List<Feed>): Completable
    fun getFeed(): Single<List<Feed>>
}