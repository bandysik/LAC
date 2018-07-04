package lac.feature.main.app.settings.city

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_city.view.*
import kotlinx.android.synthetic.main.fragment_city_dialog.*
import lac.core.feature.core.old.BaseBottomSheetDialogFragment
import lac.core.feature.core.utils.extension.argument
import lac.feature.main.R
import lac.feature.main.domain.model.City
import org.koin.android.ext.android.inject

internal class CityDialogFragment : BaseBottomSheetDialogFragment<CityDialogPresenter>(),
                                    CityDialogContract.View {

    override fun showData(data: List<City>) {
    }

    private val presenter: CityDialogContract.Presenter by inject { mapOf(Params.CITY_DIALOG_VIEW to this) }
    private val selectedCity: Int by argument(ARG_SELECTED_CITY)
    private var selectCityListener: SelectCityListener? = null

    override fun getPresenter(): CityDialogPresenter {
        return presenter as CityDialogPresenter
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_city_dialog
    }

    override fun initViews() {
        fragment_city_dialog_list.adapter = CityAdapter(selectedCity)
    }

    override fun hideProgressBar() {
    }

    override fun showProgressBar() {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parent = parentFragment
        if (parent != null) {
            selectCityListener = parent as SelectCityListener
        } else {
            selectCityListener = context as SelectCityListener
        }
    }

    override fun onDetach() {
        selectCityListener = null
        super.onDetach()
    }

    interface SelectCityListener {
        fun onSelectCity(position: Int)
    }

    private inner class ViewHolder internal constructor(inflater: LayoutInflater,
                                                        parent: ViewGroup) : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.adapter_city, parent, false)) {

        internal val text: TextView = itemView.adapter_city_text

        init {
            text.setOnClickListener {
                selectCityListener?.let {
                    it.onSelectCity(adapterPosition)
                    dismiss()
                }
            }
        }
    }

    private inner class CityAdapter internal constructor(private val selectedCity: Int) :
            RecyclerView.Adapter<ViewHolder>() {

        var data: ArrayList<City> = ArrayList()
            set(value) {
                field.clear()
                field.addAll(value)
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val marker = if (selectedCity == position) "*" else ""
            val text = "$marker ${data[position]}"
            holder.text.text = text
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }

    companion object {

        const val TAG = "CityDialogFragment"
        const val ARG_SELECTED_CITY = "selected_city"

        fun newInstance(selectedCity: Int): CityDialogFragment =
                CityDialogFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_SELECTED_CITY, selectedCity)
                    }
                }
    }
}
