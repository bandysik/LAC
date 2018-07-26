package lac.feature.main.app.mobile.detail

import lac.feature.main.app.mobile.detail.Params.FEED_CONTENT
import lac.feature.main.app.mobile.detail.Params.FEED_ID
import lac.feature.main.app.mobile.detail.Params.VIEW
import org.koin.dsl.module.applicationContext

val detailSubModule = applicationContext {
    factory { params ->
        DetailPresenter(params[VIEW],
                params[FEED_ID],
                params[FEED_CONTENT],
                get(),
                get(),
                get()) as DetailContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
    const val FEED_ID = "FEED_ID"
    const val FEED_CONTENT = "FEED_CONTENT"
}