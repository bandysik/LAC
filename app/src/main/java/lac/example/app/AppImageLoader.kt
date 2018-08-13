package lac.example.app

import android.content.Context
import android.widget.ImageView
//import com.bumptech.glide.Glide
import lac.plugin.imageloader.ImageLoader

//https://bumptech.github.io/glide/doc/getting-started.html
object AppImageLoader : ImageLoader {

    override fun load(context: Context, string: String, view: ImageView) {
//        Glide.with(context).load(string).into(view)
    }

}