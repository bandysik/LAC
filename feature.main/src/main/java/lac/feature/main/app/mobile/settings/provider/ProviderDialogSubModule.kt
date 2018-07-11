package lac.feature.main.app.mobile.settings.provider

import lac.feature.main.app.mobile.settings.provider.Params.VIEW
import org.koin.dsl.module.applicationContext

val providerDialogSubModule = applicationContext {
    factory { params ->
        ProviderDialogPresenter(params[VIEW],
                                get(),
                                get()) as ProviderDialogContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
}