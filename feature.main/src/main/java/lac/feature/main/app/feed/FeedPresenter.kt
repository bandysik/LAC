package lac.feature.main.app.feed

import lac.core.feature.core.newest.presentation.AbstractPresenter
import lac.feature.main.data.Repository

internal class FeedPresenter(override var view: FeedContract.View,
                             private val repository: Repository) : AbstractPresenter<FeedContract.View, FeedContract.Presenter>(),
                                                                   FeedContract.Presenter {

    override fun start() {
        view.showProgress()
        view.hideProgress()
        view.showData(repository.getFeed())
    }

//    override fun stop() {
//    }
}