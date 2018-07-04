package lac.feature.main.app.home

import android.content.BroadcastReceiver
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import androidx.core.widget.toast
import kotlinx.android.synthetic.main.activity_home.*
import lac.core.feature.core.network.Connectivity
import lac.core.feature.core.old.BaseActivity
import lac.core.feature.core.utils.extension.replaceFragment
import lac.feature.main.R
import lac.feature.main.app.bookmarks.BookmarksFragment
import lac.feature.main.app.feed.FeedFragment
import lac.feature.main.app.home.Params.HOME_VIEW
import lac.feature.main.app.settings.SettingsFragment
import lac.feature.main.app.settings.city.CityDialogFragment
import lac.plugin.remoteconfig.ImplRemoteConfig
import org.koin.android.ext.android.inject

internal class HomeActivity : BaseActivity<HomePresenter>(),
                              HomeContract.View,
                              CityDialogFragment.SelectCityListener {

    private val presenter: HomeContract.Presenter by inject { mapOf(HOME_VIEW to this) }

    private var navigationCurrentItem by state(R.id.navigation_home)

    private val broadcastConnectivity: BroadcastReceiver by lazy {
        Connectivity.getBroadcastReceiver({ toast("disconnected") }, { toast("connected") })
    }

    override fun getPresenter(): HomePresenter {
        return presenter as HomePresenter
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(broadcastConnectivity, Connectivity.intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastConnectivity)
    }

    private val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                navigationCurrentItem = item.itemId
                when (item.itemId) {
                    R.id.navigation_home -> {
                        presenter.onClickShowHome()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_bookmarks -> {
                        presenter.onClickShowBookmarks()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_settings -> {
                        presenter.onClickShowSettings()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    override fun getLayoutResId() =
            R.layout.activity_home

    override fun initViews() {
        //TODO move to other place
        ImplRemoteConfig.remoteConfig.fetch(this) {
            toast("remote config is loaded")
        }
        activity_home_navigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener)
        activity_home_navigation.selectedItemId = navigationCurrentItem

        val layoutParams = activity_home_navigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationViewBehavior()
    }

    override fun showHome() {
        showFragment(FeedFragment.newInstance())
    }

    override fun showBookmarks() {
        showFragment(BookmarksFragment.newInstance())
    }

    override fun showSettings() {
        showFragment(SettingsFragment.newInstance())
    }

    override fun showSelectCity(selectedCity: Int) {
        CityDialogFragment.newInstance(selectedCity)
            .show(supportFragmentManager, "dialog")
    }

    override fun onSelectCity(position: Int) {
        getPresenter().selectCity(position)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.replaceFragment(R.id.activity_home_container, fragment)
    }
}
