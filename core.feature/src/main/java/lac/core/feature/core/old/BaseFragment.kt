package lac.core.feature.core.old

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lac.core.feature.core.Pikkel
import lac.core.feature.core.PikkelDelegate

abstract class BaseFragment<out Presenter : BasePresenter> : Fragment(), BaseView,
        Pikkel by PikkelDelegate() {

    abstract fun getLayoutResId(): Int

    abstract fun initViews()

    abstract fun getPresenter(): Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restoreInstanceState(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().stop()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        getPresenter().start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }
}