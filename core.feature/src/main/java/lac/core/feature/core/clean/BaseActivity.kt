package lac.core.feature.core.clean

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lac.core.feature.core.utils.Pikkel
import lac.core.feature.core.utils.PikkelDelegate
import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseView

abstract class BaseActivity<V : BaseView<P>, out P : BasePresenter<V>> : AppCompatActivity(),
                                                                         BaseView<P>,
                                                                         Pikkel by PikkelDelegate() {

    abstract fun getLayoutResId(): Int

    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restoreInstanceState(savedInstanceState)

        setContentView(getLayoutResId())

        initViews()

        presenter.start()
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }
}
