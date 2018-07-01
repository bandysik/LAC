package lac.feature.main.app.feed

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_feed.*
import lac.core.feature.core.old.BaseFragment
import lac.core.feature.core.utils.gone
import lac.core.feature.core.utils.visible
import lac.feature.main.R
import lac.feature.main.app.detail.DetailActivity
import lac.feature.main.domain.model.Feed
import org.koin.android.ext.android.inject

internal class FeedFragment : BaseFragment<FeedPresenter>(), FeedContract.View {
    private val presenter: FeedContract.Presenter by inject { mapOf(Params.FEED_VIEW to this) }

    override fun getPresenter(): FeedPresenter {
        return presenter as FeedPresenter
    }

    private var listener = object : FeedFragmentListener {
        override fun onClickFeedItem(item: Feed) {
            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getLayoutResId() =
            R.layout.fragment_feed

    override fun initViews() {
        fragment_feed_list.adapter = FeedAdapter(listener)
    }

    override fun hideProgressBar() {
        fragment_feed_loading.gone()
    }

    override fun showProgressBar() {
        fragment_feed_loading.visible()
    }

    override fun showData(data: List<Feed>) {
        (fragment_feed_list.adapter as FeedAdapter).values = data
        fragment_feed_list.adapter.notifyDataSetChanged()
    }

    interface FeedFragmentListener {

        fun onClickFeedItem(item: Feed)
    }

    companion object {

        fun newInstance(): FeedFragment {
            val fragment = FeedFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
