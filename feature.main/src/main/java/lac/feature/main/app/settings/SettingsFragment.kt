package lac.feature.main.app.settings

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_settings.*
import lac.core.feature.core.old.BaseFragment
import lac.feature.main.R
import lac.feature.main.app.settings.city.CityDialogFragment
import lac.feature.main.app.settings.provider.ProviderDialogFragment
import org.koin.android.ext.android.inject
import java.util.*

internal class SettingsFragment : BaseFragment<SettingsPresenter>(),
                                  SettingsContract.View,
                                  CityDialogFragment.SelectCityListener,
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

    override fun openCities(selectedCity: Int) {
        CityDialogFragment.newInstance(selectedCity)
            .show(childFragmentManager, CityDialogFragment.TAG)
    }

    override fun openProviders(selectedProviders: ArrayList<Int>) {
        ProviderDialogFragment.newInstance(selectedProviders)
            .show(childFragmentManager, ProviderDialogFragment.TAG)
    }

    override fun onSelectCity(position: Int) {
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
