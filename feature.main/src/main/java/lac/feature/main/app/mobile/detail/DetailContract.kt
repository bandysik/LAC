package lac.feature.main.app.mobile.detail

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseErrorView
import lac.core.feature.core.clean.view.BaseProgressView
import lac.core.feature.core.clean.view.BaseView

internal interface DetailContract {

    interface View : BaseView<Presenter>,
            BaseProgressView,
            BaseErrorView {
        fun showTextMessage(msg: String)
        fun openPro()
    }

    interface Presenter : BasePresenter<View> {
        fun onClickPro()
        fun addBookmark()
    }
}