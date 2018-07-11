package lac.feature.main.app.mobile.notification

import lac.feature.main.app.mobile.notification.Params.NOTIFICATION_URL
import lac.feature.main.app.mobile.notification.Params.VIEW
import org.koin.dsl.module.applicationContext

val notificationSubModule = applicationContext {
    factory { params ->
        NotificationPresenter(params[VIEW],
                              params[NOTIFICATION_URL]) as NotificationContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
    const val NOTIFICATION_URL = "NOTIFICATION_URL"
}