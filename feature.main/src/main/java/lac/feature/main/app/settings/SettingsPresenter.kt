package lac.feature.main.app.settings

import lac.feature.main.data.Repository
import lac.feature.main.plugin.settings.MainSettings

internal class SettingsPresenter(private val view: SettingsContract.View,
                                 private val repository: Repository) : SettingsContract.Presenter {

    override fun onClickChangeCity() {
        view.openCity(MainSettings.settings.getCityId())
    }

    override fun onClickSelectProvider() {
        view.openProvider()
    }

    override fun changeNotification(isChecked: Boolean) {
        MainSettings.settings.setEnabledNotification(isChecked)
    }

    override fun isNotificationEnabled(): Boolean {
        return MainSettings.settings.isEnabledNotification()
    }

    override fun stop() {
    }

    override fun start() {
    }
}