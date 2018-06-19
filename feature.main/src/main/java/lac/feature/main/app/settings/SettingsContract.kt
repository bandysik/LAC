package lac.feature.main.app.settings

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseView

internal interface SettingsContract {

    interface View : BaseView {
        fun openCity(selectedCity: Int)
        fun openProvider()
    }

    interface Presenter : BasePresenter {
        fun onClickChangeCity()
        fun onClickSelectProvider()
        fun changeNotification(isChecked: Boolean)
        fun isNotificationEnabled(): Boolean
    }
}