package lac.feature.main.app.bookmarks

import lac.core.feature.core.newest.presentation.BaseDataView
import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseProgressView
import lac.core.feature.core.newest.presentation.BaseView
import lac.feature.main.domain.model.Bookmark

internal interface BookmarksContract {

    interface View : BaseView<Presenter>, BaseProgressView, BaseDataView<List<Bookmark>>

    interface Presenter : BasePresenter<View>
}