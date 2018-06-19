package lac.feature.main.app.settings

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_city.view.*
import kotlinx.android.synthetic.main.fragment_provider_dialog.*
import lac.core.feature.core.utils.extension.argument
import lac.feature.main.R

internal class CityDialogFragment : BottomSheetDialogFragment() {

    private val selectedCity: Int by argument(ARG_SELECTED_CITY)
    private val itemCount: Int by argument(ARG_ITEM_COUNT)

    private var mListener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_city_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = ItemAdapter(itemCount, selectedCity)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parent = parentFragment
        if (parent != null) {
            mListener = parent as Listener
        } else {
            mListener = context as Listener
        }
    }

    override fun onDetach() {
        mListener = null
        super.onDetach()
    }

    interface Listener {
        fun onItemClicked(position: Int)
    }

    private inner class ViewHolder internal constructor(inflater: LayoutInflater,
                                                        parent: ViewGroup) : RecyclerView.ViewHolder(
            inflater.inflate(R.layout.adapter_city, parent, false)) {

        internal val text: TextView = itemView.adapter_city_text

        init {
            text.setOnClickListener {
                mListener?.let {
                    it.onItemClicked(adapterPosition)
                    dismiss()
                }
            }
        }
    }

    private inner class ItemAdapter internal constructor(private val mItemCount: Int, private val selectedCity: Int) : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text.text = (if (selectedCity == position) "*" else "") + "city : $position"
        }

        override fun getItemCount(): Int {
            return mItemCount
        }
    }

    companion object {

        const val ARG_ITEM_COUNT = "item_count"
        const val ARG_SELECTED_CITY = "selected_city"

        fun newInstance(itemCount: Int, selectedCity: Int): CityDialogFragment =
                CityDialogFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_ITEM_COUNT, itemCount)
                        putInt(ARG_SELECTED_CITY, selectedCity)
                    }
                }
    }
}
