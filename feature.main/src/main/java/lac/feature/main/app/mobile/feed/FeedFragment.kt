package lac.feature.main.app.mobile.feed

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_feed.*
import lac.core.feature.core.clean.BaseFragment
import lac.core.feature.core.utils.gone
import lac.core.feature.core.utils.visible
import lac.feature.main.R
import lac.feature.main.app.domain.model.Feed
import lac.feature.main.app.mobile.detail.DetailActivity
import org.koin.android.ext.android.inject

internal class FeedFragment : BaseFragment<FeedContract.View, FeedContract.Presenter>(),
                              FeedContract.View {
    override fun showError(error: Throwable?) {
        fragment_feed_loading.gone()
    }

    override val presenter: FeedContract.Presenter by inject { mapOf(Params.VIEW to this) }

    private var listener = object : FeedFragmentListener {
        override fun onClickFeedItem(item: Feed) {
            DetailActivity.start(context!!, item)
        }
    }

    override fun getLayoutResId() =
            R.layout.fragment_feed

    override fun initViews() {
        fragment_feed_list.adapter = FeedAdapter(listener)
    }

    override fun hideProgress() {
        fragment_feed_loading.gone()
    }

    override fun showProgress() {
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
