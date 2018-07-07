package lac.feature.main.app.mobile.bookmarks

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.presenter.BaseRequestPresenter
import lac.core.feature.core.clean.view.BaseDataView
import lac.core.feature.core.clean.view.BaseErrorView
import lac.core.feature.core.clean.view.BaseProgressView
import lac.core.feature.core.clean.view.BaseView
import lac.feature.main.app.domain.model.Bookmark

internal interface BookmarksContract {

    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<Bookmark>>,
                     BaseErrorView

    interface Presenter : BasePresenter<View>,
                          BaseRequestPresenter<List<Bookmark>>
}