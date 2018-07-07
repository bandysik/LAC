package lac.feature.main.app.mobile.bookmarks

import lac.feature.main.app.mobile.bookmarks.Params.BOOKMARKS_VIEW
import org.koin.dsl.module.applicationContext

val bookmarksSubModule = applicationContext {
    factory { params ->
        BookmarksPresenter(params[BOOKMARKS_VIEW], get(), get()) as BookmarksContract.Presenter
    }
}

object Params {
    const val BOOKMARKS_VIEW = "BOOKMARKS_VIEW"
}