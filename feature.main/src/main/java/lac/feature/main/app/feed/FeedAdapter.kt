package lac.feature.main.app.feed

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import lac.feature.main.R
import lac.feature.main.app.feed.dummy.DummyContent

class FeedAdapter(private val values: List<DummyContent.DummyItem>,
                  private val listener: FeedFragment.FeedFragmentListener?) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_feed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = values[position]
        holder.idView.text = values[position].id
        holder.contentView.text = values[position].content

        holder.mView.setOnClickListener {
            listener?.onClickFeedItem(holder.item!!)
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val idView: TextView
        val contentView: TextView
        var item: DummyContent.DummyItem? = null

        init {
            idView = mView.findViewById(R.id.adapter_feed_id) as TextView
            contentView = mView.findViewById(R.id.adapter_feed_content) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
