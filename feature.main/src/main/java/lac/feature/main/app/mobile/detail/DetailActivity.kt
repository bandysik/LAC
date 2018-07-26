package lac.feature.main.app.mobile.detail

import android.content.Context
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import lac.core.feature.core.clean.BaseActivity
import lac.core.feature.core.utils.extension.argument
import lac.feature.main.R
import lac.feature.main.app.domain.model.Bookmark
import lac.feature.main.app.domain.model.Feed
import lac.plugin.navigator.ImplNavigator
import org.koin.android.ext.android.inject

internal class DetailActivity : BaseActivity<DetailContract.View, DetailContract.Presenter>(),
        DetailContract.View {

    override fun showError(error: Throwable?) {
    }

    private val feedId: String by argument(ARG_KEY_FEED_ID)
    private val feedContent: String by argument(ARG_KEY_FEED_CONTENT)

    override val presenter: DetailContract.Presenter by inject {
        mapOf(Params.VIEW to this,
                Params.FEED_ID to feedId,
                Params.FEED_CONTENT to feedContent)
    }

    override fun showTextMessage(msg: String) {
        activity_detail_text.text = msg
    }

    override fun hideProgress() {
        activity_detail_progressbar.visibility = View.GONE
    }

    override fun showProgress() {
        activity_detail_progressbar.visibility = View.VISIBLE
    }

    override fun getLayoutResId() =
            R.layout.activity_detail

    override fun initViews() {
        setSupportActionBar(activity_detail_toolbar)

        activity_detail_fab.setOnClickListener {
            presenter.onClickPro()
        }

        activity_detail_addBookmark.setOnClickListener {
            presenter.addBookmark()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun openPro() {
        ImplNavigator.navigator.startPro(this)
    }

    companion object {

        private const val ARG_KEY_FEED_ID = "key_feed_id"
        private const val ARG_KEY_FEED_CONTENT = "key_feed_content"

        fun start(context: Context, feed: Feed) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARG_KEY_FEED_ID, feed.id)
            intent.putExtra(ARG_KEY_FEED_CONTENT, feed.description)
            context.startActivity(intent)
        }

        fun start(context: Context, bookmark: Bookmark) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARG_KEY_FEED_ID, bookmark.id)
            intent.putExtra(ARG_KEY_FEED_CONTENT, bookmark.content)
            context.startActivity(intent)
        }
    }
}
