package lac.feature.main.app.mobile.settings.city

import lac.feature.main.app.mobile.settings.city.Params.VIEW
import org.koin.dsl.module.applicationContext

val cityDialogSubModule = applicationContext {
    factory { params ->
        CityDialogPresenter(params[VIEW], get(), get()) as CityDialogContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
}