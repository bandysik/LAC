package lac.feature.main.app.settings

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_settings.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R
import org.koin.android.ext.android.inject

internal class SettingsFragment : BaseFragment<SettingsPresenter>(),
        SettingsContract.View,
        CurrencyDialogFragment.Listener {
    private val presenter: SettingsContract.Presenter by inject { mapOf(Params.SETTINGS_VIEW to this) }

    override fun getPresenter(): SettingsPresenter {
        return presenter as SettingsPresenter
    }

    override fun getLayoutResId() =
            R.layout.fragment_settings

    override fun initViews() {
        fragment_settings_from.setOnClickListener {
            getPresenter().openFrom()
        }
        fragment_settings_to.setOnClickListener {
            getPresenter().openTo()
        }
        fragment_settings_currency.setOnClickListener {
            getPresenter().openCurrency()
        }
        fragment_settings_feedback.setOnClickListener {}

        fragment_settings_share.setOnClickListener {}

        fragment_settings_apps.setOnClickListener {}

        fragment_settings_notification.setOnCheckedChangeListener { buttonView, isChecked ->
            getPresenter().changeNotification(isChecked)
        }

        fragment_settings_notification.isChecked = getPresenter().isNotificationEnabled()
    }

    override fun openFrom() {
        CurrencyDialogFragment.newInstance(30)
                .show(childFragmentManager, "dialog")
    }

    override fun openTo() {
        CurrencyDialogFragment.newInstance(30)
                .show(childFragmentManager, "dialog")
    }

    override fun openCurrency() {
        CurrencyDialogFragment.newInstance(30)
                .show(childFragmentManager, "dialog")
    }

    override fun onItemClicked(position: Int) {
    }

    companion object {

        fun newInstance(): SettingsFragment {
            val fragment = SettingsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
