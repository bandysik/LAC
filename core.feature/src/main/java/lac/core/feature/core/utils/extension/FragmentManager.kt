package lac.core.feature.core.utils.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun FragmentManager.removeFragment(tag: String/*,
                                            slideIn: Int = R.anim.slide_left,
                                            slideOut: Int = R.anim.slide_right*/) {
    this.beginTransaction()
            .disallowAddToBackStack()
//        .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

fun FragmentManager.addFragment(containerViewId: Int, fragment: Fragment, tag: String/*,
                                         slideIn: Int = R.anim.slide_left,
                                         slideOut: Int = R.anim.slide_right*/) {
    this.beginTransaction()
            .disallowAddToBackStack()
//        .setCustomAnimations(slideIn, slideOut)
            .add(containerViewId, fragment, tag)
            .commit()
}

fun FragmentManager.replaceFragment(containerViewId: Int, fragment: Fragment) {
    this.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
}