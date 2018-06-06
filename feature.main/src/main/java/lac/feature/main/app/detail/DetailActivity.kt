package lac.feature.main.app.detail

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import lac.core.feature.core.old.CommonActivity
import lac.feature.main.R
import lac.plugin.navigator.N

class DetailActivity : CommonActivity<DetailPresenter>(), DetailContract.View {
    override fun showTextMessage(msg: String) {
        activity_detail_text.text = msg
    }

    override fun hideProgressBar() {
        activity_detail_progressbar.visibility = View.GONE
    }

    override fun showProgressBar() {
        activity_detail_progressbar.visibility = View.VISIBLE
    }

    override fun initPresenter() =
            DetailPresenter(this, "hello")

    override fun getLayoutResId() =
            R.layout.activity_detail

    override fun initViews() {
        setSupportActionBar(activity_detail_toolbar)

        activity_detail_fab.setOnClickListener { view ->
            N.navigator.startPro()
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}
