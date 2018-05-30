package lac.plugin.logger.impl

import lac.plugin.logger.Logger

internal class NetworkLog : Logger {
    override fun d(msg: String) {
        println("LOGGER NETWORK $msg")
    }

}