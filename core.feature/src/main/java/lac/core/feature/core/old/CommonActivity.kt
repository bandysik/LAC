package lac.core.feature.core.old

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lac.core.feature.core.Pikkel
import lac.core.feature.core.PikkelDelegate

abstract class CommonActivity<out Presenter : BasePresenter> : AppCompatActivity(), BaseView,
                                                               Pikkel by PikkelDelegate() {

    private lateinit var presenter: Presenter

    abstract fun initPresenter(): Presenter

    abstract fun getLayoutResId(): Int

    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restoreInstanceState(savedInstanceState)

        setContentView(getLayoutResId())

        presenter = initPresenter()

        initViews()

        presenter.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.stop()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }

    fun getPresenter(): Presenter {
        return presenter
    }
}
