package lac.feature.main.app.settings

import lac.feature.main.data.Repository
import lac.feature.main.plugin.settings.Settings

internal class SettingsPresenter(private val view: SettingsContract.View,
                                 private val repository: Repository,
                                 private val settings: Settings) : SettingsContract.Presenter {

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

    override fun stop() {
    }

    override fun start() {
    }
}