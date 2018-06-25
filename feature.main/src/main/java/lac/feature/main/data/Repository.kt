package lac.feature.main.data

import lac.feature.main.data.model.remote.Bookmark
import lac.feature.main.data.model.viewModel.DetailViewModel
import lac.feature.main.data.model.remote.Feed
import lac.feature.main.data.model.remote.City
import lac.feature.main.data.model.remote.Provider
import lac.feature.main.data.model.viewModel.SettingsViewModel

interface Repository {
    fun getBookmarks(): List<Bookmark>
    fun getDetail(id: Int): DetailViewModel
    fun getFeed(): List<Feed>
    fun getCities(): List<City>
    fun getProviders(): List<Provider>
    fun getSettings(): SettingsViewModel
}