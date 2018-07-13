package lac.feature.main.app.mobile.home

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.feature.main.app.cache.PreferencesHelper
import lac.plugin.analytic.Analytic

internal class HomePresenter(override var view: HomeContract.View,
                             private val settings: PreferencesHelper,
                             private val analytic: Analytic) : AbstractPresenter<HomeContract.View, HomeContract.Presenter>(),
                                                               HomeContract.Presenter {

    override fun start() {
        val cityId = settings.cityId
        if (cityId == -1) {
            view.showSelectCity(cityId)
        }
    }

    override fun selectCity(position: Int) {
        settings.cityId = position
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