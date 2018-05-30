package lac.plugin.logger

internal class FileLog : Logger {
    override fun d(msg: String) {
        println("LOGGER FILE $msg")
    }

}