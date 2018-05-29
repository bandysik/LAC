package lac.feature.main.notification

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_notification.*
import lac.core.feature.core.old.CommonActivity
import lac.feature.main.R

class NotificationActivity : CommonActivity<NotificationPresenter>(), NotificationContract.View {
    override fun initPresenter(): NotificationPresenter {
        val url = intent.getStringExtra("key_url")
        return NotificationPresenter(this, url)
    }

    override fun getLayoutResId() =
            R.layout.activity_notification

    override fun initViews() {
        activity_notification_webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                getPresenter().onFinishLoadPage()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                getPresenter().onStartLoadPage()
            }
        }
    }

    override fun hideProgressBar() {
        activity_notification_progressbar.visibility = View.GONE
    }

    override fun showProgressBar() {
        activity_notification_progressbar.visibility = View.VISIBLE
    }

    override fun openUrl(url: String) {
        activity_notification_webview.loadUrl(url)
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

        fun start(context: Context) {
            val intent = Intent(context, NotificationActivity::class.java)
            context.startActivity(intent)
        }
    }
}
