package lac.plugin.analytic

import lac.plugin.analytic.impl.FileAnalytic
import org.koin.dsl.module.applicationContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

object A : KoinComponent {
    private val analyticModule = applicationContext {
        bean { FileAnalytic() as Analytic }
    }

    init {
        startKoin(listOf(analyticModule))
    }

    val analytic: Analytic by A.inject()
}