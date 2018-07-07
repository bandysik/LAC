package lac.feature.main.app.mobile.settings

import lac.feature.main.app.mobile.settings.Params.SETTINGS_VIEW
import org.koin.dsl.module.applicationContext

val settingsSubModule = applicationContext {
    factory { params ->
        SettingsPresenter(params[SETTINGS_VIEW], get(), get()) as SettingsContract.Presenter
    }
}

object Params {
    const val SETTINGS_VIEW = "SETTINGS_VIEW"
}