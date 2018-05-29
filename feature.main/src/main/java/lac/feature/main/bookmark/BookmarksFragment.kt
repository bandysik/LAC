package lac.feature.main.bookmark

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R
import lac.feature.main.bookmark.dummy.DummyContent
import lac.feature.main.detail.DetailActivity

class BookmarksFragment : BaseFragment<BookmarksPresenter>(), BookmarksContract.View {
    override fun hideProgressBar() {
    }

    override fun showProgressBar() {
    }

    private var mListener = object : BookmarksFragmentListener {
        override fun onClickBookmarkItem(item: DummyContent.DummyItem) {
            DetailActivity.start(context!!)
        }
    }

    override fun initPresenter() =
            BookmarksPresenter(this)

    override fun getLayoutResId() =
            R.layout.fragment_bookmarks

    override fun initViews() {
        val context = fragment_bookmark_list.context
        fragment_bookmark_list.layoutManager = LinearLayoutManager(context)
        fragment_bookmark_list.adapter = BookmarksAdapter(DummyContent.ITEMS, mListener)
    }

    interface BookmarksFragmentListener {

        fun onClickBookmarkItem(item: DummyContent.DummyItem)
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(): BookmarksFragment {
            val fragment = BookmarksFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
