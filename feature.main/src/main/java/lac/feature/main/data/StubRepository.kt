package lac.feature.main.data

import io.reactivex.Single
import lac.feature.main.data.model.viewModel.DetailViewModel
import lac.feature.main.data.model.viewModel.SettingsViewModel
import lac.feature.main.domain.model.Bookmark
import lac.feature.main.domain.model.City
import lac.feature.main.domain.model.Feed
import lac.feature.main.domain.model.Provider

class StubRepository : Repository {
    override fun getBookmarks(): Single<List<Bookmark>> {
        val li = ArrayList<Bookmark>()
        li.add(Bookmark("1", "11"))
        li.add(Bookmark("2", "22"))
        li.add(Bookmark("3", "33"))
        li.add(Bookmark("4", "44"))
        return Single.just(li)
    }

    override fun getDetail(id: Int): DetailViewModel {
        return DetailViewModel()
    }

    override fun getFeed(): Single<List<Feed>> {
        val li = ArrayList<Feed>()
        li.add(Feed("1", "11"))
        li.add(Feed("2", "22"))
        li.add(Feed("3", "33"))
        li.add(Feed("4", "44"))
        li.add(Feed("5", "55"))
        li.add(Feed("6", "66"))
        return Single.just(li)
    }

    override fun getCities(): Single<List<City>> {
        val li = ArrayList<City>()
        li.add(City("1", "11"))
        li.add(City("2", "22"))
        li.add(City("3", "33"))
        li.add(City("4", "44"))
        li.add(City("5", "55"))
        li.add(City("6", "66"))
        return Single.just(li)
    }

    override fun getProviders(): Single<List<Provider>> {
        val li = ArrayList<Provider>()
        li.add(Provider("1", "11"))
        li.add(Provider("2", "22"))
        li.add(Provider("3", "33"))
        li.add(Provider("4", "44"))
        return Single.just(li)
    }

    override fun getSettings(): SettingsViewModel {
        return SettingsViewModel()
    }
}
