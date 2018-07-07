package lac.feature.main.app.mobile.settings.provider

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.presenter.BaseRequestPresenter
import lac.core.feature.core.clean.view.BaseDataView
import lac.core.feature.core.clean.view.BaseErrorView
import lac.core.feature.core.clean.view.BaseProgressView
import lac.core.feature.core.clean.view.BaseView
import lac.feature.main.app.domain.model.Provider

interface ProviderDialogContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<Provider>>,
                     BaseErrorView

    interface Presenter : BasePresenter<View>,
                          BaseRequestPresenter<List<Provider>>
}