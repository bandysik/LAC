package lac.plugin.imageloader

import android.content.Context
import android.widget.ImageView

interface ImageLoader {

    companion object {
        lateinit var imageLoader: ImageLoader
    }

    fun load(context: Context, string: String, view: ImageView)
}