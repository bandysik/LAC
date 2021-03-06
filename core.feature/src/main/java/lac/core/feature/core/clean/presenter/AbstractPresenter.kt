package lac.core.feature.core.clean.presenter

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import lac.core.feature.core.clean.view.BaseView

abstract class AbstractPresenter<V : BaseView<P>, out P : BasePresenter<V>> :
        BasePresenter<V> {

    override lateinit var view: V

    val disposables = CompositeDisposable()

    fun launch(job: () -> Disposable) {
        disposables.add(job())
    }

    @CallSuper
    override fun stop() {
        disposables.clear()
    }
}