package lac.feature.main.app.mobile.settings.city

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.core.feature.core.utils.extension.with
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.app.domain.repository.MainRepository

class CityDialogPresenter(override var view: CityDialogContract.View,
                          private val schedulerProvider: SchedulerProvider,
                          private val repository: MainRepository) : AbstractPresenter<CityDialogContract.View, CityDialogContract.Presenter>(),
        CityDialogContract.Presenter {

    override fun request() {
        view.showProgress()
        launch {
            repository.getCities()
                    .with(schedulerProvider)
                    .subscribe({ cities ->
                        view.showData(cities)
                        view.hideProgress()
                    }, { error ->
                        view.showError(error)
                    })
        }
    }

    override fun start() {
        request()
    }

}