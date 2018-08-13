package lac.feature.main.app.mobile.home

import android.content.BroadcastReceiver
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import androidx.core.widget.toast
import kotlinx.android.synthetic.main.activity_home.*
import lac.core.feature.core.clean.BaseActivity
import lac.core.feature.core.utils.extension.replaceFragment
import lac.core.feature.core.utils.network.Connectivity
import lac.feature.main.R
import lac.feature.main.app.mobile.bookmarks.BookmarksFragment
import lac.feature.main.app.mobile.feed.FeedFragment
import lac.feature.main.app.mobile.home.Params.VIEW
import lac.feature.main.app.mobile.settings.SettingsFragment
import lac.feature.main.app.mobile.settings.city.CityDialogFragment
import org.koin.android.ext.android.inject

internal class HomeActivity : BaseActivity<HomeContract.View, HomeContract.Presenter>(),
        HomeContract.View,
        CityDialogFragment.SelectCityListener {

    override val presenter: HomeContract.Presenter by inject { mapOf(VIEW to this) }

    private var navigationCurrentItem by state(R.id.navigation_home)

    private val broadcastConnectivity: BroadcastReceiver by lazy {
        Connectivity.getBroadcastReceiver({ toast("disconnected") }, { toast("connected") })
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(broadcastConnectivity, Connectivity.intentFilter)
    }

    override fun onStop() {
        unregisterReceiver(broadcastConnectivity)
        super.onStop()
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
//        RemoteConfig.remoteConfig.fetch {
//            toast("remote config is loaded")
//        }
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
//        Admin.fill()
    }

    override fun showSettings() {
        showFragment(SettingsFragment.newInstance())
    }

    override fun showSelectCity(selectedCity: Int) {
        CityDialogFragment.newInstance(selectedCity)
                .show(supportFragmentManager, "dialog")
    }

    override fun onSelectCity(position: Int) {
        presenter.selectCity(position)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.replaceFragment(R.id.activity_home_container, fragment)
    }
}
