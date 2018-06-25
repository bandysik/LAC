package lac.feature.main.app.detail

import lac.feature.main.data.Repository

internal class DetailPresenter(private val view: DetailContract.View,
                               private val msg: String,
                               private val repository: Repository) : DetailContract.Presenter {

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