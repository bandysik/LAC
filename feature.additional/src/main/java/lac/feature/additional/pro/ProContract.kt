package lac.feature.additional.pro

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseView
import lac.core.feature.core.clean.view.BaseProgressView

interface ProContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView {
        fun showData()
        fun showImage(string:String)
    }

    interface Presenter : BasePresenter<View> {
        fun retrieveData()
    }
}