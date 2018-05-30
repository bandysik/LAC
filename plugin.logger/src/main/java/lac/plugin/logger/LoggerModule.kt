package lac.plugin.logger

import org.koin.dsl.module.applicationContext

val loggerModule = applicationContext {
    bean { FileLog() as Logger }
}