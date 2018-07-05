package lac.feature.main.app.settings.city

import lac.core.feature.core.newest.presentation.BaseDataView
import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseProgressView
import lac.core.feature.core.newest.presentation.BaseView
import lac.feature.main.domain.model.City

interface CityDialogContract {
    interface View : BaseView<Presenter>,
                     BaseProgressView,
                     BaseDataView<List<City>>

    interface Presenter : BasePresenter<View>
}