package lac.plugin.imageloader

interface ImageLoader {

    companion object {
        lateinit var analytic: ImageLoader
    }

    fun load()
}