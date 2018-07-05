package lac.core.feature.core.newest.presentation

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T
}