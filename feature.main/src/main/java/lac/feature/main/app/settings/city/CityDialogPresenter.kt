package lac.feature.main.app.settings.city

import lac.core.feature.core.newest.presentation.AbstractPresenter
import lac.core.feature.core.utils.extension.with
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.data.Repository

class CityDialogPresenter(override var view: CityDialogContract.View,
                          private val schedulerProvider: SchedulerProvider,
                          private val repository: Repository) : AbstractPresenter<CityDialogContract.View, CityDialogContract.Presenter>(),
                                                                CityDialogContract.Presenter {

    override fun request() {
        view.showProgress()
        launch {
            repository.getCities()
                .with(schedulerProvider)
                .subscribe({ cities ->
                               view.showData(cities)
                               view.hideProgress()
                           }, { error -> view.showError(error) })
        }
    }

    override fun start() {
        request()
    }

//    override fun stop() {
//    }
}