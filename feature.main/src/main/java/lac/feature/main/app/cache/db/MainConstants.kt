package lac.feature.main.app.cache.db

object MainConstants {

    internal val QUERY_GET_ALL_BOOKMARKS = "SELECT * FROM " + Db.BookmarkTable.TABLE_NAME
    internal val QUERY_GET_ALL_CITIES = "SELECT * FROM " + Db.CitiesTable.TABLE_NAME
    internal val QUERY_GET_ALL_FEEDS = "SELECT * FROM " + Db.FeedsTable.TABLE_NAME
    internal val QUERY_GET_FEED_BY_ID = "SELECT * FROM " + Db.FeedsTable.TABLE_NAME + " WHERE feed_id=?"
    internal val QUERY_GET_ALL_PROVIDERS = "SELECT * FROM " + Db.ProvidersTable.TABLE_NAME

}