package lac.feature.main.app.home

import lac.feature.main.plugin.settings.MainSettings
import lac.plugin.analytic.A

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
        A.analytic.eventOpenHome()
        view.showHome()
    }

    override fun onClickShowBookmarks() {
        A.analytic.eventOpenBookmarks()
        view.showBookmarks()
    }

    override fun onClickShowSettings() {
        A.analytic.eventOpenSettings()
        view.showSettings()
    }
}