//package lac.example.feature.detail
//
//import org.koin.dsl.module.applicationContext
//
//val detailModule = applicationContext {
//    factory { params -> DetailPresenter(params[Params.DETAIL_VIEW]) as DetailContract.Presenter }
//}
//
//object Params {
//    const val DETAIL_VIEW = "DETAIL_VIEW"
//}