package lac.feature.main.app.bookmarks

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R
import lac.feature.main.R.id.fragment_bookmark_list
import lac.feature.main.app.bookmarks.dummy.DummyContent
import lac.feature.main.app.detail.DetailActivity
import org.koin.android.ext.android.inject

internal class BookmarksFragment : BaseFragment<BookmarksPresenter>(), BookmarksContract.View {
    private val presenter: BookmarksContract.Presenter by inject { mapOf(Params.BOOKMARKS_VIEW to this) }

    override fun getPresenter(): BookmarksPresenter {
        return presenter as BookmarksPresenter
    }

    override fun hideProgressBar() {
    }

    override fun showProgressBar() {
    }

    private var mListener = object : BookmarksFragmentListener {
        override fun onClickBookmarkItem(item: DummyContent.DummyItem) {
            DetailActivity.start(context!!)
        }
    }

    override fun getLayoutResId() =
            R.layout.fragment_bookmarks

    override fun initViews() {
        fragment_bookmark_list.adapter = BookmarksAdapter(DummyContent.ITEMS, mListener)
    }

    interface BookmarksFragmentListener {

        fun onClickBookmarkItem(item: DummyContent.DummyItem)
    }

    companion object {

        fun newInstance(): BookmarksFragment {
            val fragment = BookmarksFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
