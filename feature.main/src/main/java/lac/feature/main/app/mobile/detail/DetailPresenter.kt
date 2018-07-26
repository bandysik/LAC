package lac.feature.main.app.mobile.detail

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.core.feature.core.utils.extension.with
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.app.domain.model.Bookmark
import lac.feature.main.app.domain.repository.MainRepository
import lac.plugin.remoteconfig.RemoteConfig

internal class DetailPresenter(override var view: DetailContract.View,
                               private val feedId: String,
                               private val feedContent: String,
                               private val schedulerProvider: SchedulerProvider,
                               private val repository: MainRepository,
                               private val remoteConfig: RemoteConfig) : AbstractPresenter<DetailContract.View, DetailContract.Presenter>(),
        DetailContract.Presenter {


    override fun onClickPro() {
        if (remoteConfig.isEnabledPro()) {
            view.openPro()
        }
    }

    override fun start() {
        view.showProgress()
        launch {
            repository.getFeedById(feedId)
                    .with(schedulerProvider)
                    .subscribe({ feed ->
                        view.showTextMessage(feed.description)
                        view.hideProgress()
                    }, { error ->
                        view.showError(error)
                    })
        }
        view.hideProgress()
    }

    override fun addBookmark() {
        launch {
            repository.saveBookmark(Bookmark(feedId, feedContent))
                    .with(schedulerProvider)
                    .subscribe({
                        view.hideProgress()
                    },
                            { error ->
                                view.showError(error)
                            })
        }
    }
}