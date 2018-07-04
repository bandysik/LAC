package lac.plugin.analytic

object ImplAnalytic {
    lateinit var analytic: Analytic
}
//object ImplAnalytic : KoinComponent {
//    private val analyticModule = applicationContext {
//        bean { FileAnalytic() as Analytic }
//    }
//
//    init {
//        startKoin(listOf(analyticModule))
//    }
//
//    val analytic: Analytic by ImplAnalytic.inject()
//}