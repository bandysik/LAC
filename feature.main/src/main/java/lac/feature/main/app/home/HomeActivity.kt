package lac.feature.main.app.home

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import lac.core.feature.core.old.BaseActivity
import lac.core.feature.core.utils.extension.replaceFragment
import lac.feature.main.R
import lac.feature.main.app.bookmarks.BookmarksFragment
import lac.feature.main.app.feed.FeedFragment
import lac.feature.main.app.home.Params.HOME_VIEW
import lac.feature.main.app.settings.SettingsFragment
import org.koin.android.ext.android.inject

internal class HomeActivity :
        BaseActivity<HomePresenter>(),
        HomeContract.View {

    override fun getPresenter(): HomePresenter {
        return presenter as HomePresenter
    }

    private val presenter: HomeContract.Presenter by inject { mapOf(HOME_VIEW to this) }

    private var navigationCurrentItem by state(R.id.navigation_home)

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

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.replaceFragment(R.id.activity_home_container, fragment)
    }
}
