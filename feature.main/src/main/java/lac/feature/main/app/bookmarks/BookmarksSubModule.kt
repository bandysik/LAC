package lac.feature.main.app.bookmarks

import lac.feature.main.app.bookmarks.Params.BOOKMARKS_VIEW
import org.koin.dsl.module.applicationContext

val bookmarksSubModule = applicationContext {
    factory { params -> BookmarksPresenter(params[BOOKMARKS_VIEW]) as BookmarksContract.Presenter }
}

object Params {
    const val BOOKMARKS_VIEW = "BOOKMARKS_VIEW"
}