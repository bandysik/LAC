package lac.feature.main.app.bookmarks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import lac.feature.main.R
import lac.feature.main.app.bookmarks.dummy.DummyContent

internal class BookmarksAdapter(private val mValues: List<DummyContent.DummyItem>,
                       private val mListener: BookmarksFragment.BookmarksFragmentListener?) : RecyclerView.Adapter<BookmarksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_bookmark, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mIdView.text = mValues[position].id
        holder.mContentView.text = mValues[position].content

        holder.mView.setOnClickListener {
            mListener?.onClickBookmarkItem(holder.mItem!!)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        val mContentView: TextView
        var mItem: DummyContent.DummyItem? = null

        init {
            mIdView = mView.findViewById(R.id.adapter_bookmark_id) as TextView
            mContentView = mView.findViewById(R.id.adapter_bookmark_text) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
