package lac.core.feature.core.clean

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lac.core.feature.core.utils.Pikkel
import lac.core.feature.core.utils.PikkelDelegate
import lac.core.feature.core.clean.presenter.BasePresenter
import lac.core.feature.core.clean.view.BaseView

abstract class BaseFragment<V : BaseView<P>, out P : BasePresenter<V>> : Fragment(),
                                                                         BaseView<P>,
                                                                         Pikkel by PikkelDelegate() {

    abstract fun getLayoutResId(): Int

    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restoreInstanceState(savedInstanceState)
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        presenter.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }
}