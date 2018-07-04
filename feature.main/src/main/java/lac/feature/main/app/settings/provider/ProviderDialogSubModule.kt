package lac.feature.main.app.settings.provider

import lac.feature.main.app.settings.provider.Params.PROVIDER_DIALOG_VIEW
import org.koin.dsl.module.applicationContext

val providerDialogSubModule = applicationContext {
    factory { params ->
        ProviderDialogPresenter(params[PROVIDER_DIALOG_VIEW],
                                get()) as ProviderDialogContract.Presenter
    }
}

object Params {
    const val PROVIDER_DIALOG_VIEW = "PROVIDER_DIALOG_VIEW"
}