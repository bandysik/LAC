package lac.feature.main.app.mobile.settings

import lac.feature.main.app.mobile.settings.Params.VIEW
import org.koin.dsl.module.applicationContext

val settingsSubModule = applicationContext {
    factory { params ->
        SettingsPresenter(params[VIEW], get(), get()) as SettingsContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
}