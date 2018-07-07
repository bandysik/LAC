package lac.feature.additional.pro

import kotlinx.android.synthetic.main.activity_pro.*
import lac.core.feature.core.clean.BaseActivity
import lac.feature.additional.R
import lac.plugin.admin.Admin
import org.koin.android.ext.android.inject

class ProActivity : BaseActivity<ProContract.View, ProContract.Presenter>(), ProContract.View {

    override val presenter: ProContract.Presenter by inject { mapOf(Params.PRO_VIEW to this) }

    override fun getLayoutResId(): Int {
        return R.layout.activity_pro
    }

    override fun initViews() {
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Admin.fill()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.retrieveData()
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun hideProgress() {
    }

    override fun showProgress() {
    }

    override fun showData() {
    }
}
