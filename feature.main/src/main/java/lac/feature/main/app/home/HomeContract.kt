package lac.feature.main.app.home

import lac.core.feature.core.newest.presentation.BasePresenter
import lac.core.feature.core.newest.presentation.BaseView

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