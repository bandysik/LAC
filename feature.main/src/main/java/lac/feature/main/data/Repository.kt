package lac.feature.main.data

import io.reactivex.Single
import lac.feature.main.data.model.viewModel.DetailViewModel
import lac.feature.main.data.model.viewModel.SettingsViewModel
import lac.feature.main.domain.model.Bookmark
import lac.feature.main.domain.model.City
import lac.feature.main.domain.model.Feed
import lac.feature.main.domain.model.Provider

interface Repository {
    fun getBookmarks(): Single<List<Bookmark>>
    fun getDetail(id: Int): DetailViewModel
    fun getFeed(): Single<List<Feed>>
    fun getCities(): Single<List<City>>
    fun getProviders(): Single<List<Provider>>
    fun getSettings(): SettingsViewModel
}