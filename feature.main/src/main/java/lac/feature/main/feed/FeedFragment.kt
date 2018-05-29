package lac.feature.main.feed

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_feed.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R
import lac.feature.main.detail.DetailActivity
import lac.feature.main.feed.dummy.DummyContent

class FeedFragment : BaseFragment<FeedPresenter>(), FeedContract.View {
    override fun hideProgressBar() {
    }

    override fun showProgressBar() {
    }

    private var mListener = object : FeedFragmentListener {
        override fun onClickFeedItem(item: DummyContent.DummyItem) {
            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initPresenter() =
            FeedPresenter(this)

    override fun getLayoutResId() =
            R.layout.fragment_feed

    override fun initViews() {
        val context = fragment_feed_list.context
        fragment_feed_list.layoutManager = LinearLayoutManager(context)
        fragment_feed_list.adapter = FeedAdapter(DummyContent.ITEMS, mListener)
    }

    interface FeedFragmentListener {

        fun onClickFeedItem(item: DummyContent.DummyItem)
    }

    companion object {

        private val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(): FeedFragment {
            val fragment = FeedFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
