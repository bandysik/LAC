package lac.feature.main.app.home

import lac.feature.main.plugin.settings.MainSettings

internal class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    override fun start() {
        val cityId = MainSettings.settings.getCityId()
        if (cityId == -1) {
            view.showSelectCity(cityId)
        }
    }

    override fun selectCity(position: Int) {
        MainSettings.settings.setCity(position)
    }

    override fun stop() {
    }

    override fun onClickShowHome() {
        view.showHome()
    }

    override fun onClickShowBookmarks() {
        view.showBookmarks()
    }

    override fun onClickShowSettings() {
        view.showSettings()
    }
}