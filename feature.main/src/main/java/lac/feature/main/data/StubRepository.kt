package lac.feature.main.data

import lac.feature.main.data.model.Bookmark
import lac.feature.main.data.model.DetailViewModel
import lac.feature.main.data.model.Feed
import lac.feature.main.data.model.City
import lac.feature.main.data.model.Provider
import lac.feature.main.data.model.SettingsViewModel

class StubRepository : Repository {
    override fun getBookmarks(): List<Bookmark> {
        val li = ArrayList<Bookmark>()
        li.add(Bookmark("1", "11"))
        li.add(Bookmark("2", "22"))
        return li
    }

    override fun getDetail(id: Int): DetailViewModel {
        return DetailViewModel()
    }

    override fun getFeed(): List<Feed> {
        val li = ArrayList<Feed>()
        li.add(Feed("1", "11"))
        li.add(Feed("2", "22"))
        li.add(Feed("3", "33"))
        return li
    }

    override fun getCities(): List<City> {
        val li = ArrayList<City>()
        li.add(City("1", "11"))
        li.add(City("2", "22"))
        return li
    }

    override fun getProviders(): List<Provider> {
        val li = ArrayList<Provider>()
        li.add(Provider("1", "11"))
        li.add(Provider("2", "22"))
        return li
    }

    override fun getSettings(): SettingsViewModel {
        return SettingsViewModel()
    }
}
