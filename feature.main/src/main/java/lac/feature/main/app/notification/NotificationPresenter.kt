package lac.feature.main.app.notification

internal class NotificationPresenter(private val view: NotificationContract.View, private val url: String) :
        NotificationContract.Presenter {

    override fun onStartLoadPage() {
        view.showProgressBar()
    }

    override fun onFinishLoadPage() {
        view.hideProgressBar()
    }

    override fun stop() {
    }

    override fun start() {
        view.openUrl(url)
    }
}