package lac.feature.main.app.cache.db

object Db {
    object BookmarkTable {
        const val TABLE_NAME = "bookmarks"

        const val BOOKMARK_ID = "bookmark_id"
        const val CONTENT = "content"

        const val CREATE =
                "CREATE TABLE $TABLE_NAME " +
                "(" +
                "$BOOKMARK_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "$CONTENT TEXT NOT NULL" +
                "); "
    }
}