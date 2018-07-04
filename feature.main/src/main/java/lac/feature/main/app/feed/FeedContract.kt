package lac.feature.main.app.feed

import lac.core.feature.core.old.BaseDataView
import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView
import lac.feature.main.domain.model.Feed

internal interface FeedContract {

    interface View : BaseView, BaseProgressView, BaseDataView<List<Feed>>

    interface Presenter : BasePresenter
}