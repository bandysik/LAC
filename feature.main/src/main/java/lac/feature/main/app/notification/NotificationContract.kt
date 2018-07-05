package lac.feature.main.app.notification

import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseProgressView
import lac.core.feature.core.newest.presentation.BaseView

internal interface NotificationContract {

    interface View : BaseView<Presenter>, BaseProgressView {
        fun openUrl(url: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onFinishLoadPage()
        fun onStartLoadPage()
    }
}