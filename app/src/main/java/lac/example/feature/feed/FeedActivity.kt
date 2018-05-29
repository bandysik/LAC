//package lac.example.feature.feed
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import kotlinx.android.synthetic.main.activity_feed.*
//import lac.example.R
//import lac.example.base.BaseMvpAppCompatActivity
//
//class FeedActivity : BaseMvpAppCompatActivity(), FeedContract.View {
//
//    lateinit var presenter: FeedContract.Presenter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_feed)
//
//        presenter = FeedPresenter(this)
//        presenter.start()
//
//        bindViews()
//    }
//
//    override fun bindViews() {
//        activity_feed_tvMessage.text = intent.getStringExtra(EXTRA_KEY_MESSAGE)
//    }
//
//    companion object {
//
//        const val EXTRA_KEY_MESSAGE = "extra_key_message"
//
//        operator fun invoke(context: Context, message: String) {
//            val intent = Intent(context, FeedActivity::class.java)
//            intent.putExtra(EXTRA_KEY_MESSAGE, message)
//            context.startActivity(intent)
//        }
//    }
//}
