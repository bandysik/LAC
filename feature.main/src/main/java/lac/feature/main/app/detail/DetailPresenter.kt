package lac.feature.main.app.detail

import lac.feature.main.data.Repository
import lac.plugin.remoteconfig.RemoteConfig

internal class DetailPresenter(private val view: DetailContract.View,
                               private val msg: String,
                               private val repository: Repository,
                               private val remoteConfig: RemoteConfig) : DetailContract.Presenter {

    override fun onClickPro() {
        if (remoteConfig.isEnabledPro()) {
            view.openPro()
        }
    }

    override fun start() {
        view.showProgressBar()
        view.showTextMessage(msg)
        view.hideProgressBar()
    }

    override fun stop() {
    }
}