package lac.feature.main.app.settings.city

import lac.core.feature.core.newest.presentation.*
import lac.feature.main.domain.model.City

interface CityDialogContract {
    interface View : BaseView<Presenter>, BaseProgressView, BaseDataView<List<City>>, BaseErrorView

    interface Presenter : BasePresenter<View>, BaseRequestPresenter<List<City>>
}