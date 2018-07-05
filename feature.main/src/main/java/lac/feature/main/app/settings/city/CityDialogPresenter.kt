package lac.feature.main.app.settings.city

import lac.core.feature.core.newest.presentation.AbstractPresenter
import lac.feature.main.data.Repository

class CityDialogPresenter(override var view: CityDialogContract.View,
                          private val repository: Repository) : AbstractPresenter<CityDialogContract.View, CityDialogContract.Presenter>(),
                                                                CityDialogContract.Presenter {

    override fun start() {
    }

//    override fun stop() {
//    }
}