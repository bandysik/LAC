package lac.feature.main.app.mobile.settings

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.feature.main.app.cache.PreferencesHelper
import lac.feature.main.app.domain.repository.MainRepository
import java.util.*

internal class SettingsPresenter(override var view: SettingsContract.View,
                                 private val repository: MainRepository,
                                 private val settings: PreferencesHelper) : AbstractPresenter<SettingsContract.View, SettingsContract.Presenter>(),
                                                                            SettingsContract.Presenter {

    override fun onClickChangeCity() {
        view.openCities(settings.cityId)
    }

    override fun onClickSelectProvider() {
        val providers = settings.providers.map { Integer.parseInt(it) }
        view.openProviders(providers as ArrayList<Int>)
    }

    override fun changeNotification(isChecked: Boolean) {
        settings.isEnabledNotification = isChecked
    }

    override fun isNotificationEnabled(): Boolean {
        return settings.isEnabledNotification
    }

    override fun start() {
    }
}