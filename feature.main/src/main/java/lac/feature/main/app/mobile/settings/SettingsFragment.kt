package lac.feature.main.app.mobile.settings

import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.fragment_settings.*
import lac.core.feature.core.clean.BaseFragment
import lac.feature.main.R
import lac.feature.main.app.mobile.settings.city.CityDialogFragment
import lac.feature.main.app.mobile.settings.provider.ProviderDialogFragment
import org.koin.android.ext.android.inject
import java.util.*

internal class SettingsFragment : BaseFragment<SettingsContract.View, SettingsContract.Presenter>(),
        SettingsContract.View,
        CityDialogFragment.SelectCityListener,
        ProviderDialogFragment.Listener {

    override val presenter: SettingsContract.Presenter by inject { mapOf(Params.VIEW to this) }

    override fun getLayoutResId() =
            R.layout.fragment_settings

    override fun initViews() {
        fragment_settings_from.setOnClickListener {
            presenter.onClickChangeCity()
        }
        fragment_settings_to.setOnClickListener {
            presenter.onClickSelectProvider()
        }
        fragment_settings_feedback.setOnClickListener {}

        fragment_settings_share.setOnClickListener {}

        fragment_settings_apps.setOnClickListener {}

        fragment_settings_notification.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener
        { _, isChecked -> presenter.changeNotification(isChecked) })

        fragment_settings_notification.isChecked = presenter.isNotificationEnabled()
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
