package lac.feature.main.app.home

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    override fun start() {
    }

    override fun stop() {
    }

    override fun onClickShowHome() {
        view.showHome()
    }

    override fun onClickShowBookmarks() {
        view.showBookmarks()
    }

    override fun onClickShowSettings() {
        view.showSettings()
    }
}