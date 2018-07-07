package lac.feature.main.app.mobile.settings

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseView
import java.util.*

internal interface SettingsContract {

    interface View : BaseView<Presenter> {
        fun openCities(selectedCity: Int)
        fun openProviders(selectedProviders: ArrayList<Int>)
    }

    interface Presenter : BasePresenter<View> {
        fun onClickChangeCity()
        fun onClickSelectProvider()
        fun changeNotification(isChecked: Boolean)
        fun isNotificationEnabled(): Boolean
    }
}