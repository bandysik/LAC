package lac.feature.main.app.settings.city

import lac.core.feature.core.old.BaseDataView
import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseProgressView
import lac.core.feature.core.old.BaseView
import lac.feature.main.domain.model.City

interface CityDialogContract {
    interface View : BaseView, BaseProgressView, BaseDataView<List<City>>

    interface Presenter : BasePresenter
}