package lac.feature.main.data

import lac.feature.main.data.model.viewModel.DetailViewModel
import lac.feature.main.data.model.viewModel.SettingsViewModel
import lac.feature.main.domain.model.Bookmark
import lac.feature.main.domain.model.City
import lac.feature.main.domain.model.Feed
import lac.feature.main.domain.model.Provider

interface Repository {
    fun getBookmarks(): List<Bookmark>
    fun getDetail(id: Int): DetailViewModel
    fun getFeed(): List<Feed>
    fun getCities(): List<City>
    fun getProviders(): List<Provider>
    fun getSettings(): SettingsViewModel
}