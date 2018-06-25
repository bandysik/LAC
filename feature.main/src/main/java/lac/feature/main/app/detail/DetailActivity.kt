package lac.feature.main.app.detail

import android.content.Context
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import lac.core.feature.core.old.BaseActivity
import lac.feature.main.R
import lac.plugin.navigator.N
import org.koin.android.ext.android.inject

internal class DetailActivity : BaseActivity<DetailContract.Presenter>(), DetailContract.View {

    private val presenter: DetailContract.Presenter by inject { mapOf(Params.DETAIL_VIEW to this) }

    override fun getPresenter(): DetailPresenter {
        return presenter as DetailPresenter
    }

    override fun showTextMessage(msg: String) {
        activity_detail_text.text = msg
    }

    override fun hideProgressBar() {
        activity_detail_progressbar.visibility = View.GONE
    }

    override fun showProgressBar() {
        activity_detail_progressbar.visibility = View.VISIBLE
    }

    override fun getLayoutResId() =
            R.layout.activity_detail

    override fun initViews() {
        setSupportActionBar(activity_detail_toolbar)

        activity_detail_fab.setOnClickListener {
            presenter.onClickPro()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun openPro() {
        N.navigator.startPro(this)
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}
