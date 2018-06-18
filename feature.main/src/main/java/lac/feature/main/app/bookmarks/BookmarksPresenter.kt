package lac.feature.main.app.bookmarks

internal class BookmarksPresenter(private val view: BookmarksContract.View) : BookmarksContract.Presenter {
    override fun start() {
        view.showProgressBar()
        view.hideProgressBar()
    }

    override fun stop() {
    }
}