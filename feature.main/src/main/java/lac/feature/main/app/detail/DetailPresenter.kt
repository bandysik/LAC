package lac.feature.main.app.detail

class DetailPresenter(private val view: DetailContract.View, private val msg: String) :
        DetailContract.Presenter {

    override fun start() {
        view.showTextMessage(msg)
    }

    override fun stop() {
    }
}