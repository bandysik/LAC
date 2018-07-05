package lac.feature.main.app.notification

import lac.core.feature.core.newest.presentation.AbstractPresenter

internal class NotificationPresenter(override var view: NotificationContract.View,
                                     private val url: String) : AbstractPresenter<NotificationContract.View, NotificationContract.Presenter>(),
                                                                NotificationContract.Presenter {

    override fun onStartLoadPage() {
        view.showProgress()
    }

    override fun onFinishLoadPage() {
        view.hideProgress()
    }

    override fun stop() {
    }

    override fun start() {
        view.openUrl(url)
    }
}