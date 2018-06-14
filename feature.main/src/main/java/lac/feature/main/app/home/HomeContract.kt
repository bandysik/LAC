package lac.feature.main.app.home

import lac.core.feature.core.old.BasePresenter
import lac.core.feature.core.old.BaseView

internal interface HomeContract {

    interface View : BaseView{
        fun showHome()
        fun showBookmarks()
        fun showSettings()
    }

    interface Presenter : BasePresenter {
        fun onClickShowHome()
        fun onClickShowBookmarks()
        fun onClickShowSettings()
    }
}