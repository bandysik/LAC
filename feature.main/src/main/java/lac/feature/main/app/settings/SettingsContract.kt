package lac.feature.main.app.settings

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseView
import java.util.*

internal interface SettingsContract {

    interface View : BaseView {
        fun openCities(selectedCity: Int)
        fun openProviders(selectedProviders: ArrayList<Int>)
    }

    interface Presenter : BasePresenter {
        fun onClickChangeCity()
        fun onClickSelectProvider()
        fun changeNotification(isChecked: Boolean)
        fun isNotificationEnabled(): Boolean
    }
}