package lac.plugin.logger.impl

import lac.plugin.logger.Logger

internal class FileLog : Logger {
    override fun d(msg: String) {
        println("LOGGER FILE $msg")
    }

}