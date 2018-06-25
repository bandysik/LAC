package lac.feature.main.app.bookmarks

import lac.feature.main.data.Repository

internal class BookmarksPresenter(private val view: BookmarksContract.View,
                                  private val repository: Repository) : BookmarksContract.Presenter {

    override fun start() {
        view.showProgressBar()
        view.hideProgressBar()
        view.showData(repository.getBookmarks())
    }

    override fun stop() {
    }
}