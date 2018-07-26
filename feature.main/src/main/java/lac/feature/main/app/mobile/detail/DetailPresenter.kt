package lac.feature.main.app.mobile.detail

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.feature.main.app.domain.repository.MainRepository
import lac.plugin.remoteconfig.RemoteConfig

internal class DetailPresenter(override var view: DetailContract.View,
                               private val msg: String,
                               private val repository: MainRepository,
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
}