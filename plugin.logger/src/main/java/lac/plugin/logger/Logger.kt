package lac.plugin.logger

interface Logger {
    companion object {
        lateinit var logger: Logger
    }

    fun d(msg: String)
}