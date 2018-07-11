package lac.feature.main.app.mobile.detail

import lac.feature.main.app.mobile.detail.Params.VIEW
import org.koin.dsl.module.applicationContext

val detailSubModule = applicationContext {
    factory { params ->
        DetailPresenter(params[VIEW],
                        "hello",
                        get(),
                        get()) as DetailContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
}