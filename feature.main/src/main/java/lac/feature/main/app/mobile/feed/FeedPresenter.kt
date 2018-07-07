package lac.feature.main.app.mobile.feed

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.core.feature.core.utils.extension.with
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.old.data.Repository

internal class FeedPresenter(override var view: FeedContract.View,
                             private val schedulerProvider: SchedulerProvider,
                             private val repository: Repository) : AbstractPresenter<FeedContract.View, FeedContract.Presenter>(),
                                                                   FeedContract.Presenter {

    override fun request() {
        view.showProgress()
        launch {
            repository.getFeed()
                .with(schedulerProvider)
                .subscribe({ feed ->
                               view.showData(feed)
                               view.hideProgress()
                           }, { error -> view.showError(error) })
        }
    }

    override fun start() {
        request()
    }

//    override fun stop() {
//    }
}