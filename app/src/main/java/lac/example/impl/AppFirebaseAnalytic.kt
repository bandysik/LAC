package lac.example.impl

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import lac.plugin.analytic.Analytic

class AppFirebaseAnalytic(context: Context) : Analytic {
    private var firebaseAnalytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    override fun event(keyEvent: String, bundle: Bundle) {
        firebaseAnalytics.logEvent(keyEvent, bundle)
    }

    override fun eventOpenHome() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "EVENT_OPEN_HOME")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "page")
        event(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    override fun eventOpenBookmarks() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "2")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "EVENT_OPEN_BOOKMARKS")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "page")
        event(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    override fun eventOpenSettings() {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "3")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "EVENT_OPEN_SETTINGS")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "page")
        event(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

}