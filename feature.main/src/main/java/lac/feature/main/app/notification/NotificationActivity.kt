package lac.feature.main.app.notification

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_notification.*
import lac.core.feature.core.old.BaseActivity
import lac.core.feature.core.utils.extension.argument
import lac.feature.main.R
import org.koin.android.ext.android.inject

internal class NotificationActivity : BaseActivity<NotificationPresenter>(),
                                      NotificationContract.View {

    private val url: String by argument(ARG_KEY_URL)

    private val presenter: NotificationContract.Presenter by inject {
        mapOf(Params.NOTIFICATION_VIEW to this, Params.NOTIFICATION_VIEW to url)
    }

    override fun getPresenter(): NotificationPresenter {
        return presenter as NotificationPresenter
    }

    override fun getLayoutResId() =
            R.layout.activity_notification

    override fun initViews() {
        activity_notification_webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                presenter.onFinishLoadPage()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                presenter.onStartLoadPage()
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

        private const val ARG_KEY_URL = "key_url"

        fun start(context: Context, url: String) {
            val intent = Intent(context, NotificationActivity::class.java)
            intent.putExtra(ARG_KEY_URL, url)
            context.startActivity(intent)
        }
    }
}
