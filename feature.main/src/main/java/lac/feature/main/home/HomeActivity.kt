package lac.feature.main.home

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import lac.core.feature.core.old.CommonActivity
import lac.feature.main.R
import lac.feature.main.bookmark.BookmarksFragment
import lac.feature.main.feed.FeedFragment
import lac.feature.main.home.Params.HOME_VIEW
import lac.feature.main.settings.SettingsFragment
import org.koin.android.ext.android.inject


class HomeActivity : CommonActivity<HomePresenter>(), HomeContract.View {

    val presenter: HomeContract.Presenter by inject { mapOf(HOME_VIEW to this) }

    private var navigationCurrentItem by state(R.id.navigation_home)

    private val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                navigationCurrentItem = item.itemId
                when (item.itemId) {
                    R.id.navigation_home -> {
                        replaceFragment(FeedFragment.newInstance())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_bookmarks -> {
                        replaceFragment(BookmarksFragment.newInstance())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_settings -> {
                        replaceFragment(SettingsFragment.newInstance())
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    override fun initPresenter() =
            HomePresenter(this)

    override fun getLayoutResId() =
            R.layout.activity_home

    override fun initViews() {
        activity_home_navigation.setOnNavigationItemSelectedListener(
                onNavigationItemSelectedListener)
        activity_home_navigation.selectedItemId = navigationCurrentItem

        val layoutParams = activity_home_navigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationViewBehavior()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.activity_home_container, fragment)
                .commit()
    }
}
