package lac.feature.main.app.feed

class FeedPresenter(private val view: FeedContract.View) : FeedContract.Presenter {

    override fun start() {
        view.showProgressBar()
    }

    override fun stop() {
    }
}