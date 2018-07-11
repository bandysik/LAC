package lac.feature.main.app.mobile.home

import lac.feature.main.app.mobile.home.Params.VIEW
import org.koin.dsl.module.applicationContext

val homeSubModule = applicationContext {
    factory { params -> HomePresenter(params[VIEW], get(), get()) as HomeContract.Presenter }
}

object Params {
    const val VIEW = "VIEW"
}