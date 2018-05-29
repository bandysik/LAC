package lac.feature.main.notification

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView

interface NotificationContract {

    interface View : BaseView, BaseProgressView {
        fun openUrl(url: String)
    }

    interface Presenter : BasePresenter {
        fun onFinishLoadPage()
        fun onStartLoadPage()
    }
}