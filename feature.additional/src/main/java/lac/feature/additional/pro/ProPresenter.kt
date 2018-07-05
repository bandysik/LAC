package lac.feature.additional.pro

import lac.core.feature.core.newest.presentation.AbstractPresenter

class ProPresenter(override var view: ProContract.View) : AbstractPresenter<ProContract.View, ProContract.Presenter>(),
                                                          ProContract.Presenter {

    override fun start() {
    }

    override fun retrieveData() {
        view.showData()
    }
}