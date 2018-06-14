package lac.feature.main.app.bookmarks

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView

internal interface BookmarksContract {

    interface View : BaseView, BaseProgressView

    interface Presenter : BasePresenter
}