package lac.feature.main.app.feed

internal class FeedPresenter(private val view: FeedContract.View) : FeedContract.Presenter {

    override fun start() {
        view.showProgressBar()
        view.hideProgressBar()
    }

    override fun stop() {
    }
}