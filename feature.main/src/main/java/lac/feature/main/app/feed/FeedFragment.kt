package lac.feature.main.app.feed

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_feed.*
import lac.core.feature.core.old.BaseFragment
import lac.core.feature.core.utils.gone
import lac.core.feature.core.utils.visible
import lac.feature.main.R
import lac.feature.main.app.detail.DetailActivity
import lac.feature.main.app.feed.dummy.DummyContent
import org.koin.android.ext.android.inject

internal class FeedFragment : BaseFragment<FeedPresenter>(), FeedContract.View {
    private val presenter: FeedContract.Presenter by inject { mapOf(Params.FEED_VIEW to this) }

    override fun getPresenter(): FeedPresenter {
        return presenter as FeedPresenter
    }

    private var mListener = object : FeedFragmentListener {
        override fun onClickFeedItem(item: DummyContent.DummyItem) {
            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getLayoutResId() =
            R.layout.fragment_feed

    override fun initViews() {
        fragment_feed_list.adapter = FeedAdapter(DummyContent.ITEMS, mListener)
    }

    override fun showData() {
        fragment_feed_list.adapter.notifyDataSetChanged()
    }

    override fun hideProgressBar() {
        fragment_feed_loading.gone()
    }

    override fun showProgressBar() {
        fragment_feed_loading.visible()
    }

    interface FeedFragmentListener {

        fun onClickFeedItem(item: DummyContent.DummyItem)
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
