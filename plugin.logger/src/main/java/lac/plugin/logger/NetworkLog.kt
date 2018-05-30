package lac.plugin.logger

internal class NetworkLog : Logger {
    override fun d(msg: String) {
        println("LOGGER NETWORK $msg")
    }

}