package lac.core.feature.core.clean.view

import lac.core.feature.core.clean.presenter.BasePresenter

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T
}