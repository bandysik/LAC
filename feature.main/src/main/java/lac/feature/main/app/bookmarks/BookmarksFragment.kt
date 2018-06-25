package lac.feature.main.app.bookmarks

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import lac.core.feature.core.old.BaseFragment
import lac.core.feature.core.utils.gone
import lac.core.feature.core.utils.visible
import lac.feature.main.R
import lac.feature.main.app.detail.DetailActivity
import lac.feature.main.data.model.remote.Bookmark
import org.koin.android.ext.android.inject

internal class BookmarksFragment : BaseFragment<BookmarksPresenter>(), BookmarksContract.View {

    private val presenter: BookmarksContract.Presenter by inject { mapOf(Params.BOOKMARKS_VIEW to this) }

    private var listener = object : BookmarksFragmentListener {
        override fun onClickBookmarkItem(item: Bookmark) {
            DetailActivity.start(context!!)
        }
    }

    override fun getPresenter(): BookmarksPresenter {
        return presenter as BookmarksPresenter
    }

    override fun hideProgressBar() {
        fragment_bookmark_loading.gone()
    }

    override fun showProgressBar() {
        fragment_bookmark_loading.visible()
    }

    override fun getLayoutResId() =
            R.layout.fragment_bookmarks

    override fun initViews() {
        fragment_bookmark_list.adapter = BookmarksAdapter(listener)
    }

    override fun showData(data: List<Bookmark>) {
        (fragment_bookmark_list.adapter as BookmarksAdapter).data = data
        fragment_bookmark_list.adapter.notifyDataSetChanged()
    }

    interface BookmarksFragmentListener {

        fun onClickBookmarkItem(item: Bookmark)
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
