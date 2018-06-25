package lac.feature.main.app.home

import lac.feature.main.app.home.Params.HOME_VIEW
import org.koin.dsl.module.applicationContext

val homeSubModule = applicationContext {
    factory { params -> HomePresenter(params[HOME_VIEW], get(), get()) as HomeContract.Presenter }
}

object Params {
    const val HOME_VIEW = "HOME_VIEW"
}