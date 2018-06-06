package lac.feature.main.app.settings

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_settings.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R

class SettingsFragment : BaseFragment<SettingsPresenter>(),
        SettingsContract.View,
        CurrencyDialogFragment.Listener {

    override fun getLayoutResId() =
            R.layout.fragment_settings

    override fun initPresenter() =
            SettingsPresenter(this)

    override fun initViews() {
        fragment_settings_from.setOnClickListener {
            CurrencyDialogFragment.newInstance(30)
                    .show(childFragmentManager, "dialog")
        }
        fragment_settings_to.setOnClickListener {
            CurrencyDialogFragment.newInstance(30)
                    .show(childFragmentManager, "dialog")
        }
        fragment_settings_currency.setOnClickListener {
            CurrencyDialogFragment.newInstance(30)
                    .show(childFragmentManager, "dialog")
        }
        fragment_settings_feedback.setOnClickListener {}

        fragment_settings_share.setOnClickListener {}

        fragment_settings_apps.setOnClickListener {}
    }

    override fun onItemClicked(position: Int) {
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(): SettingsFragment {
            val fragment = SettingsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
