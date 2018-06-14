package lac.feature.main.app.detail

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView

internal interface DetailContract {

    interface View : BaseView, BaseProgressView {
        fun showTextMessage(msg: String)
        fun openPro()
    }

    interface Presenter : BasePresenter {
        fun onClickPro()
    }
}