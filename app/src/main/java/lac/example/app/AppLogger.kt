package lac.example.app

import lac.plugin.logger.Logger
import timber.log.Timber

object AppLogger : Logger {
    init {
        Timber.plant(Timber.DebugTree())
    }

    override fun d(msg: String) {
        Timber.d(msg)
    }
}