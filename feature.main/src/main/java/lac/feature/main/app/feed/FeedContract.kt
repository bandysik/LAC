package lac.feature.main.app.feed

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView

interface FeedContract {

    interface View : BaseView{
        fun hideProgressBar()
        fun showProgressBar()
        fun showData()
    }

    interface Presenter : BasePresenter
}