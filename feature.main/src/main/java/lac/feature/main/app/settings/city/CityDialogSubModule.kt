package lac.feature.main.app.settings.city

import lac.feature.main.app.settings.city.Params.CITY_DIALOG_VIEW
import org.koin.dsl.module.applicationContext

val cityDialogSubModule = applicationContext {
    factory { params ->
        CityDialogPresenter(params[CITY_DIALOG_VIEW], get(), get()) as CityDialogContract.Presenter
    }
}

object Params {
    const val CITY_DIALOG_VIEW = "CITY_DIALOG_VIEW"
}