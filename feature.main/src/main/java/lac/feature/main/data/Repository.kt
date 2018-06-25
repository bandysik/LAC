package lac.feature.main.data

import lac.feature.main.data.model.Bookmark
import lac.feature.main.data.model.DetailViewModel
import lac.feature.main.data.model.Feed
import lac.feature.main.data.model.City
import lac.feature.main.data.model.Provider
import lac.feature.main.data.model.SettingsViewModel

interface Repository {
    fun getBookmarks(): List<Bookmark>
    fun getDetail(id: Int): DetailViewModel
    fun getFeed(): List<Feed>
    fun getCities(): List<City>
    fun getProviders(): List<Provider>
    fun getSettings(): SettingsViewModel
}