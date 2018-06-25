package lac.feature.main.app.detail

import lac.feature.main.app.detail.Params.DETAIL_VIEW
import org.koin.dsl.module.applicationContext

val detailSubModule = applicationContext {
    factory { params -> DetailPresenter(params[DETAIL_VIEW], "hello", get(), get()) as DetailContract.Presenter }
}

object Params {
    const val DETAIL_VIEW = "DETAIL_VIEW"
}