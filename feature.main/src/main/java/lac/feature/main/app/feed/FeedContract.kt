package lac.feature.main.app.feed

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseView
import lac.feature.main.data.model.Feed

internal interface FeedContract {

    interface View : BaseView{
        fun hideProgressBar()
        fun showProgressBar()
        fun showData(data: List<Feed>)
    }

    interface Presenter : BasePresenter
}