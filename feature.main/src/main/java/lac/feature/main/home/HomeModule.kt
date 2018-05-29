package lac.feature.main.home

import lac.feature.main.home.Params.HOME_VIEW
import org.koin.dsl.module.applicationContext

val homeModule = applicationContext {
    factory { params -> HomePresenter(params[HOME_VIEW]) as HomeContract.Presenter }
}

object Params {
    const val HOME_VIEW = "HOME_VIEW"
}