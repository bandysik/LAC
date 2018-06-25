package lac.feature.main.app.feed

import lac.feature.main.data.Repository

internal class FeedPresenter(private val view: FeedContract.View,
                             private val repository: Repository) : FeedContract.Presenter {

    override fun start() {
        view.showProgressBar()
        view.hideProgressBar()
        view.showData(repository.getFeed())
    }

    override fun stop() {
    }
}