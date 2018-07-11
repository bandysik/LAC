package lac.feature.main.app.mobile.feed

import lac.feature.main.app.mobile.feed.Params.VIEW
import org.koin.dsl.module.applicationContext

val feedSubModule = applicationContext {
    factory { params -> FeedPresenter(params[VIEW], get(), get()) as FeedContract.Presenter }
}

object Params {
    const val VIEW = "VIEW"
}