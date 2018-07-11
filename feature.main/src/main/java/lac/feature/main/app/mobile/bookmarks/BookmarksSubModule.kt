package lac.feature.main.app.mobile.bookmarks

import lac.feature.main.app.mobile.bookmarks.Params.VIEW
import org.koin.dsl.module.applicationContext

val bookmarksSubModule = applicationContext {
    factory { params ->
        BookmarksPresenter(params[VIEW], get(), get()) as BookmarksContract.Presenter
    }
}

object Params {
    const val VIEW = "VIEW"
}