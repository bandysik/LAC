package lac.feature.main.feed

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView

interface FeedContract {

    interface View : BaseView, BaseProgressView

    interface Presenter : BasePresenter
}