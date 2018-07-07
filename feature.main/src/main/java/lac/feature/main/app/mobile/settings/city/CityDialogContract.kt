package lac.feature.main.app.mobile.settings.city

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.presenter.BaseRequestPresenter
import lac.core.feature.core.clean.view.BaseDataView
import lac.core.feature.core.clean.view.BaseErrorView
import lac.core.feature.core.clean.view.BaseProgressView
import lac.core.feature.core.clean.view.BaseView
import lac.feature.main.app.domain.model.City

interface CityDialogContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<City>>,
                     BaseErrorView

    interface Presenter : BasePresenter<View>,
                          BaseRequestPresenter<List<City>>
}