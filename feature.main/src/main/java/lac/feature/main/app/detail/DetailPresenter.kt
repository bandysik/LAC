package lac.feature.main.app.detail

import lac.core.feature.core.newest.presentation.AbstractPresenter
import lac.feature.main.data.Repository
import lac.plugin.remoteconfig.RemoteConfig

internal class DetailPresenter(override var view: DetailContract.View,
                               private val msg: String,
                               private val repository: Repository,
                               private val remoteConfig: RemoteConfig) : AbstractPresenter<DetailContract.View, DetailContract.Presenter>(),
                                                                         DetailContract.Presenter {

    override fun onClickPro() {
        if (remoteConfig.isEnabledPro()) {
            view.openPro()
        }
    }

    override fun start() {
        view.showProgress()
        view.showTextMessage(msg)
        view.hideProgress()
    }
//
//    override fun stop() {
//    }
}