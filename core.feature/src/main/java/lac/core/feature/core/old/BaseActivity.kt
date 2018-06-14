package lac.core.feature.core.old

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lac.core.feature.core.Pikkel
import lac.core.feature.core.PikkelDelegate

abstract class BaseActivity<out Presenter : BasePresenter> : AppCompatActivity(), BaseView,
        Pikkel by PikkelDelegate() {

    abstract fun getLayoutResId(): Int

    abstract fun initViews()

    abstract fun getPresenter(): Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restoreInstanceState(savedInstanceState)

        setContentView(getLayoutResId())

        initViews()

        getPresenter().start()
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().stop()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }
}
