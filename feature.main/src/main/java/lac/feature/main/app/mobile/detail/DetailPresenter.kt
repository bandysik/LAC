package lac.feature.main.app.mobile.detail

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.feature.main.old.data.Repository
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