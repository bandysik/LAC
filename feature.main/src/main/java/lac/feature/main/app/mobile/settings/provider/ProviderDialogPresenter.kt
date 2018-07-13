package lac.feature.main.app.mobile.settings.provider

import lac.core.feature.core.clean.presenter.AbstractPresenter
import lac.core.feature.core.utils.extension.with
import lac.core.feature.core.utils.rx.SchedulerProvider
import lac.feature.main.app.domain.repository.MainRepository

class ProviderDialogPresenter(override var view: ProviderDialogContract.View,
                              private val schedulerProvider: SchedulerProvider,
                              private val repository: MainRepository) : AbstractPresenter<ProviderDialogContract.View, ProviderDialogContract.Presenter>(),
                                                                        ProviderDialogContract.Presenter {

    override fun request() {
        view.showProgress()
        launch {
            repository.getProviders()
                .with(schedulerProvider)
                .subscribe({ providers ->
                               view.showData(providers)
                               view.hideProgress()
                           }, { error -> view.showError(error) })
        }
    }

    override fun start() {
        request()
    }
//
//    override fun stop() {
//    }
}