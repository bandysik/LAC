package lac.feature.main.app.bookmarks

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView
import lac.feature.main.data.model.Bookmark

internal interface BookmarksContract {

    interface View : BaseView, BaseProgressView {
        fun showData(data: List<Bookmark>)
    }

    interface Presenter : BasePresenter
}