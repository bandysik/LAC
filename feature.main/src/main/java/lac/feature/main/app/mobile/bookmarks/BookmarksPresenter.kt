package lac.feature.main.app.mobile.bookmarks

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.core.feature.core.utils.extension.with
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.app.domain.repository.MainRepository

internal class BookmarksPresenter(override var view: BookmarksContract.View,
                                  private val schedulerProvider: SchedulerProvider,
                                  private val repository: MainRepository) : AbstractPresenter<BookmarksContract.View, BookmarksContract.Presenter>(),
        BookmarksContract.Presenter {

    override fun request() {
        view.showProgress()
        launch {
            repository.getBookmarks()
                    .with(schedulerProvider)
                    .subscribe({ bookmarks ->
                        view.showData(bookmarks)
                        view.hideProgress()
                    }, { error ->
                        view.showError(error)
                    })

        }
    }

    override fun start() {
        request()
    }
}