package lac.feature.main.app.mobile.notification

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseProgressView
import lac.core.feature.core.clean.view.BaseView

internal interface NotificationContract {

    interface View : BaseView<Presenter>,
                     BaseProgressView {
        fun openUrl(url: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onFinishLoadPage()
        fun onStartLoadPage()
    }
}