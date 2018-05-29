//package lac.example.feature.home
//
//import android.os.Bundle
//import android.view.View
//import kotlinx.android.synthetic.main.activity_home.*
//import lac.example.R
//import lac.example.base.BaseMvpAppCompatActivity
//import lac.example.feature.detail.DetailActivity
//import lac.example.feature.home.Params.HOME_VIEW
//import org.koin.android.ext.android.inject
//
//class HomeActivity : BaseMvpAppCompatActivity(), HomeContract.View {
//
//    val presenter: HomeContract.Presenter by inject { mapOf(HOME_VIEW to this) }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//
//        presenter.start()
//
//        bindViews()
//    }
//
//    override fun bindViews() {
//        activity_home_btnDetail.setOnClickListener {
//            presenter.onClickDetail()
//        }
//    }
//
//    override fun openDetailScreen(message: String) {
//        DetailActivity(this, message)
//    }
//
//    override fun showMessage(message: String) {
//        activity_home_tvMessage.text = message
//    }
//
//    override fun showLoading() {
//        activity_home_pbLoading.visibility = View.VISIBLE
//    }
//
//    override fun hideLoading() {
//        activity_home_pbLoading.visibility = View.GONE
//    }
//}
