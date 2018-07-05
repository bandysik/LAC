package lac.feature.main.app.settings.provider

import lac.core.feature.core.newest.presentation.AbstractPresenter
import lac.feature.main.data.Repository

class ProviderDialogPresenter(override var view: ProviderDialogContract.View,
                              private val repository: Repository) : AbstractPresenter<ProviderDialogContract.View, ProviderDialogContract.Presenter>(),
                                                                    ProviderDialogContract.Presenter {

    override fun start() {
    }
//
//    override fun stop() {
//    }
}