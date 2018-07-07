package lac.feature.main.app.settings.provider

import lac.core.feature.core.newest.presentation.*
import lac.feature.main.domain.model.Provider

interface ProviderDialogContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<Provider>>,
                     BaseErrorView

    interface Presenter : BasePresenter<View>, BaseRequestPresenter<List<Provider>>
}