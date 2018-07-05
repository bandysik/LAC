package lac.core.feature.core.newest.presentation

interface BasePresenter<T> {

    fun start()
    fun stop()

    var view: T
}