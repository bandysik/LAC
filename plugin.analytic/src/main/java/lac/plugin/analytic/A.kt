package lac.plugin.analytic

object A {
    lateinit var analytic: Analytic
}
//object A : KoinComponent {
//    private val analyticModule = applicationContext {
//        bean { FileAnalytic() as Analytic }
//    }
//
//    init {
//        startKoin(listOf(analyticModule))
//    }
//
//    val analytic: Analytic by A.inject()
//}