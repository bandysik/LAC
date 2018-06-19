package lac.feature.main.app.settings

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_settings.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R
import org.koin.android.ext.android.inject

internal class SettingsFragment : BaseFragment<SettingsPresenter>(),
        SettingsContract.View,
        CityDialogFragment.Listener,
        ProviderDialogFragment.Listener {

    private val presenter: SettingsContract.Presenter by inject { mapOf(Params.SETTINGS_VIEW to this) }

    override fun getPresenter(): SettingsPresenter {
        return presenter as SettingsPresenter
    }

    override fun getLayoutResId() =
            R.layout.fragment_settings

    override fun initViews() {
        fragment_settings_from.setOnClickListener {
            getPresenter().onClickChangeCity()
        }
        fragment_settings_to.setOnClickListener {
            getPresenter().onClickSelectProvider()
        }
        fragment_settings_feedback.setOnClickListener {}

        fragment_settings_share.setOnClickListener {}

        fragment_settings_apps.setOnClickListener {}

        fragment_settings_notification.setOnCheckedChangeListener { buttonView, isChecked ->
            getPresenter().changeNotification(isChecked)
        }

        fragment_settings_notification.isChecked = getPresenter().isNotificationEnabled()
    }

    override fun openCity(selectedCity:Int) {
        CityDialogFragment.newInstance(30, selectedCity)
                .show(childFragmentManager, "dialog")
    }

    override fun openProvider() {
        ProviderDialogFragment.newInstance(30)
                .show(childFragmentManager, "dialog")
    }

    override fun onItemClicked(position: Int) {
    }

    override fun onProviderItemClicked(position: Int) {
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
