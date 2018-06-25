package lac.feature.main.app.home

import lac.feature.main.plugin.settings.Settings
import lac.plugin.analytic.Analytic

internal class HomePresenter(private val view: HomeContract.View,
                             private val settings: Settings,
                             private val analytic: Analytic) : HomeContract.Presenter {

    override fun start() {
        val cityId = settings.getCityId()
        if (cityId == -1) {
            view.showSelectCity(cityId)
        }
    }

    override fun selectCity(position: Int) {
        settings.setCity(position)
    }

    override fun stop() {
    }

    override fun onClickShowHome() {
        analytic.eventOpenHome()
        view.showHome()
    }

    override fun onClickShowBookmarks() {
        analytic.eventOpenBookmarks()
        view.showBookmarks()
    }

    override fun onClickShowSettings() {
        analytic.eventOpenSettings()
        view.showSettings()
    }
}