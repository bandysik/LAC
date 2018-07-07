package lac.feature.main.app.mobile.notification

import lac.feature.main.app.mobile.notification.Params.NOTIFICATION_URL
import lac.feature.main.app.mobile.notification.Params.NOTIFICATION_VIEW
import org.koin.dsl.module.applicationContext

val notificationSubModule = applicationContext {
    factory { params ->
        NotificationPresenter(params[NOTIFICATION_VIEW],
                              params[NOTIFICATION_URL]) as NotificationContract.Presenter
    }
}

object Params {
    const val NOTIFICATION_VIEW = "NOTIFICATION_VIEW"
    const val NOTIFICATION_URL = "NOTIFICATION_URL"
}