package lac.feature.main.app.feed

import lac.core.feature.core.newest.presentation.BaseDataView
import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseProgressView
import lac.core.feature.core.newest.presentation.BaseView
import lac.feature.main.domain.model.Feed

internal interface FeedContract {

    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<Feed>>

    interface Presenter : BasePresenter<View>
}