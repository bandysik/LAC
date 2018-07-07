package lac.feature.main.app.feed

import lac.feature.main.app.feed.Params.FEED_VIEW
import org.koin.dsl.module.applicationContext

val feedSubModule = applicationContext {
    factory { params -> FeedPresenter(params[FEED_VIEW], get(), get()) as FeedContract.Presenter }
}

object Params {
    const val FEED_VIEW = "FEED_VIEW"
}