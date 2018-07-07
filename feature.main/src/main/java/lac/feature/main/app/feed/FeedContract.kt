package lac.feature.main.app.feed

import lac.core.feature.core.newest.presentation.*
import lac.feature.main.domain.model.Feed

internal interface FeedContract {

    interface View : BaseView<Presenter>, BaseProgressView, BaseDataView<List<Feed>>, BaseErrorView

    interface Presenter : BasePresenter<View>, BaseRequestPresenter<List<Feed>>
}