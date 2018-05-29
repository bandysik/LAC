//package lac.example.feature.detail
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import kotlinx.android.synthetic.main.activity_detail.*
//import lac.example.R
//import lac.example.base.BaseMvpAppCompatActivity
//import lac.example.feature.detail.Params.DETAIL_VIEW
//import org.koin.android.ext.android.inject
//
//class DetailActivity : BaseMvpAppCompatActivity(), DetailContract.View {
//
//    val presenter: DetailContract.Presenter by inject { mapOf(DETAIL_VIEW to this) }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
//
//        presenter.start()
//
//        bindViews()
//    }
//
//    override fun bindViews() {
//        activity_detail_tvMessage.text = intent.getStringExtra(EXTRA_KEY_MESSAGE)
//    }
//
//    companion object {
//
//        const val EXTRA_KEY_MESSAGE = "extra_key_message"
//
//        operator fun invoke(context: Context, message: String) {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra(EXTRA_KEY_MESSAGE, message)
//            context.startActivity(intent)
//        }
//    }
//}
