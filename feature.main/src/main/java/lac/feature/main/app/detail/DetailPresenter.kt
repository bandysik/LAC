package lac.feature.main.app.detail

internal class DetailPresenter(private val view: DetailContract.View, private val msg: String) :
        DetailContract.Presenter {
    override fun onClickPro() {
        view.openPro()
    }

    override fun start() {
        view.showProgressBar()
        view.showTextMessage(msg)
        view.hideProgressBar()
    }

    override fun stop() {
    }
}