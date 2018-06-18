package lac.feature.main.app.settings

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseView

internal interface SettingsContract {

    interface View : BaseView {
        fun openFrom()
        fun openTo()
        fun openCurrency()
    }

    interface Presenter : BasePresenter {
        fun openFrom()
        fun openTo()
        fun openCurrency()
        fun changeNotification(isChecked: Boolean)
        fun isNotificationEnabled(): Boolean
    }
}