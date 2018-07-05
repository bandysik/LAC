package lac.feature.main.app.settings.provider

import lac.core.feature.core.newest.presentation.BaseDataView
import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseProgressView
import lac.core.feature.core.newest.presentation.BaseView
import lac.feature.main.domain.model.Provider

interface ProviderDialogContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<Provider>>

    interface Presenter : BasePresenter<View>
}