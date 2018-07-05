package lac.feature.main.app.detail

import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseProgressView
import lac.core.feature.core.newest.presentation.BaseView

internal interface DetailContract {

    interface View : BaseView<Presenter>, BaseProgressView {
        fun showTextMessage(msg: String)
        fun openPro()
    }

    interface Presenter : BasePresenter<View> {
        fun onClickPro()
    }
}