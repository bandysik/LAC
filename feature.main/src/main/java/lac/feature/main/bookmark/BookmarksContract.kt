package lac.feature.main.bookmark

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView

interface BookmarksContract {

    interface View : BaseView, BaseProgressView

    interface Presenter : BasePresenter
}