package lac.feature.main.app.bookmarks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import lac.feature.main.R
import lac.feature.main.data.model.remote.Bookmark

internal class BookmarksAdapter(private val listener: BookmarksFragment.BookmarksFragmentListener?) :
        RecyclerView.Adapter<BookmarksAdapter.ViewHolder>() {

    var data: List<Bookmark> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_bookmark, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = data[position]
        holder.idView.text = data[position].id
        holder.contentView.text = data[position].content

        holder.view.setOnClickListener {
            listener?.onClickBookmarkItem(holder.item!!)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView
        val contentView: TextView
        var item: Bookmark? = null

        init {
            idView = view.findViewById(R.id.adapter_bookmark_id) as TextView
            contentView = view.findViewById(R.id.adapter_bookmark_text) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
