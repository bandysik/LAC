package lac.feature.main.app.mobile.home

import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseView

internal interface HomeContract {

    interface View : BaseView<Presenter> {
        fun showHome()
        fun showBookmarks()
        fun showSettings()
        fun showSelectCity(selectedCity: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun onClickShowHome()
        fun onClickShowBookmarks()
        fun onClickShowSettings()
        fun selectCity(position: Int)
    }
}