package lac.plugin.logger

import lac.plugin.logger.impl.FileLog
import org.koin.dsl.module.applicationContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

object L : KoinComponent {
    private val loggerModule = applicationContext {
        bean { FileLog() as Logger }
    }

    init {
        startKoin(listOf(loggerModule))
    }

    val logger: Logger by L.inject()

}