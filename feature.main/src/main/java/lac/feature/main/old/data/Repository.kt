package lac.feature.main.old.data

import io.reactivex.Single
import lac.feature.main.old.data.model.viewModel.DetailViewModel
import lac.feature.main.old.data.model.viewModel.SettingsViewModel
import lac.feature.main.app.domain.model.Bookmark
import lac.feature.main.app.domain.model.City
import lac.feature.main.app.domain.model.Feed
import lac.feature.main.app.domain.model.Provider

interface Repository {
    fun getBookmarks(): Single<List<Bookmark>>
    fun getDetail(id: Int): DetailViewModel
    fun getFeed(): Single<List<Feed>>
    fun getCities(): Single<List<City>>
    fun getProviders(): Single<List<Provider>>
    fun getSettings(): SettingsViewModel
}