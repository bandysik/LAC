package lac.feature.main.app.mobile.settings

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.feature.main.old.data.Repository
import lac.feature.main.plugin.settings.Settings

internal class SettingsPresenter(override var view: SettingsContract.View,
                                 private val repository: Repository,
                                 private val settings: Settings) : AbstractPresenter<SettingsContract.View, SettingsContract.Presenter>(),
                                                                   SettingsContract.Presenter {

    override fun onClickChangeCity() {
        view.openCities(settings.getCityId())
    }

    override fun onClickSelectProvider() {
        view.openProviders(settings.getProviders())
    }

    override fun changeNotification(isChecked: Boolean) {
        settings.setEnabledNotification(isChecked)
    }

    override fun isNotificationEnabled(): Boolean {
        return settings.isEnabledNotification()
    }

//    override fun stop() {
//    }

    override fun start() {
    }
}