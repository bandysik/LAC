package lac.core.feature.core.newest.presentation

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lac.core.feature.core.Pikkel
import lac.core.feature.core.PikkelDelegate

abstract class BaseBottomSheetDialogFragment<V : BaseView<P>, out P : BasePresenter<V>> :
        BottomSheetDialogFragment(),
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