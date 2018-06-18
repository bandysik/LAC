package lac.feature.main.app.settings

import lac.feature.main.plugin.settings.MainSettings

internal class SettingsPresenter(private val view: SettingsContract.View) : SettingsContract.Presenter {

    override fun openFrom() {
        view.openFrom()
    }

    override fun openTo() {
        view.openTo()
    }

    override fun openCurrency() {
        view.openCurrency()
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