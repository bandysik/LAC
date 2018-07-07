package lac.feature.main.app.settings.provider

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_provider.view.*
import kotlinx.android.synthetic.main.fragment_provider_dialog.*
import lac.core.feature.core.newest.presentation.BaseBottomSheetDialogFragment
import lac.core.feature.core.utils.extension.argument
import lac.feature.main.R
import lac.feature.main.domain.model.Provider
import org.koin.android.ext.android.inject

internal class ProviderDialogFragment : BaseBottomSheetDialogFragment<ProviderDialogContract.View, ProviderDialogContract.Presenter>(),
        ProviderDialogContract.View {
    override fun showError(error: Throwable?) {
    }

    override val presenter: ProviderDialogContract.Presenter by inject { mapOf(Params.PROVIDER_DIALOG_VIEW to this) }
    private val selectedProviders: ArrayList<Int> by argument(ARG_SELECTED_PROVIDERS)
    private var listener: Listener? = null

    override fun getLayoutResId(): Int {
        return R.layout.fragment_provider_dialog
    }

    override fun initViews() {
        fragent_provider_dialog_list.adapter = ItemAdapter(selectedProviders)
    }

    override fun showData(data: List<Provider>) {
        (fragent_provider_dialog_list.adapter as ItemAdapter).data = data as ArrayList<Provider>
    }

    override fun hideProgress() {
    }

    override fun showProgress() {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parent = parentFragment
        if (parent != null) {
            listener = parent as Listener
        } else {
            listener = context as Listener
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    interface Listener {
        fun onProviderItemClicked(position: Int)
    }

    private inner class ViewHolder internal constructor(inflater: LayoutInflater,
                                                        parent: ViewGroup) : RecyclerView.ViewHolder(
            inflater.inflate(R.layout.adapter_provider, parent, false)) {

        internal val text: TextView = itemView.adapter_provider_text

        init {
            text.setOnClickListener {
                listener?.let {
                    it.onProviderItemClicked(adapterPosition)
                    dismiss()
                }
            }
        }
    }

    private inner class ItemAdapter internal constructor(private val selectedProviders: ArrayList<Int>) :
            RecyclerView.Adapter<ViewHolder>() {

        var data: ArrayList<Provider> = ArrayList()
            set(value) {
                field.clear()
                field.addAll(value)
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val text = data[position].name
            holder.text.text = text
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }

    companion object {
        const val TAG = "ProviderDialogFragment"
        const val ARG_SELECTED_PROVIDERS = "selected_providers"

        fun newInstance(selectedProviders: ArrayList<Int>): ProviderDialogFragment =
                ProviderDialogFragment().apply {
                    arguments = Bundle().apply {
                        putIntegerArrayList(ARG_SELECTED_PROVIDERS, selectedProviders)
                    }
                }
    }
}
