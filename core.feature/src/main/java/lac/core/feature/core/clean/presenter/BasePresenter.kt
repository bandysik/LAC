package lac.core.feature.core.clean.presenter

interface BasePresenter<T> {

    fun start()
    fun stop()

    var view: T
}