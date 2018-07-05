package lac.feature.additional.pro

import lac.feature.additional.pro.Params.PRO_VIEW
import org.koin.dsl.module.applicationContext

val proSubModule = applicationContext {
    factory { params ->
        ProPresenter(params[PRO_VIEW]) as ProContract.Presenter
    }
}

object Params {
    const val PRO_VIEW = "PRO_VIEW"
}