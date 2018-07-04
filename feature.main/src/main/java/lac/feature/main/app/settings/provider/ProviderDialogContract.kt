package lac.feature.main.app.settings.provider

import lac.core.feature.core.old.BaseDataView
import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView
import lac.feature.main.domain.model.Provider

interface ProviderDialogContract {
    interface View : BaseView, BaseProgressView, BaseDataView<List<Provider>>

    interface Presenter : BasePresenter
}