package lac.feature.main.app.bookmarks

import lac.core.feature.core.newest.presentation.AbstractPresenter
import lac.feature.main.data.Repository

internal class BookmarksPresenter(override var view: BookmarksContract.View,
                                  private val repository: Repository) : AbstractPresenter<BookmarksContract.View, BookmarksContract.Presenter>(),
                                                                        BookmarksContract.Presenter {

    override fun start() {
        view.showProgress()
        view.hideProgress()
        view.showData(repository.getBookmarks())
    }
//
//    override fun stop() {
//    }
}