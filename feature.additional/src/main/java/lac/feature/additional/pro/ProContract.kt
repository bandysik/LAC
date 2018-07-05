package lac.feature.additional.pro

import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseView
import lac.core.feature.core.newest.presentation.BaseProgressView

interface ProContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView {
        fun showData()
    }

    interface Presenter : BasePresenter<View> {
        fun retrieveData()
    }
}