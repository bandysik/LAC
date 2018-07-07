package lac.feature.main.app.bookmarks

import lac.core.feature.core.newest.presentation.*
import lac.feature.main.domain.model.Bookmark

internal interface BookmarksContract {

    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<Bookmark>>,
                     BaseErrorView

    interface Presenter : BasePresenter<View>, BaseRequestPresenter<List<Bookmark>>
}