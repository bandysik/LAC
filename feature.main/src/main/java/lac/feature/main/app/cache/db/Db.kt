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

    object CitiesTable {
        const val TABLE_NAME = "cities"

        const val CITY_ID = "city_id"
        const val NAME = "name"

        const val CREATE =
                "CREATE TABLE $TABLE_NAME " +
                        "(" +
                        "$CITY_ID INTEGER PRIMARY KEY NOT NULL," +
                        "$NAME TEXT NOT NULL" +
                        "); "
    }

    object ProvidersTable {
        const val TABLE_NAME = "providers"

        const val PROVIDER_ID = "provider_id"
        const val NAME = "name"

        const val CREATE =
                "CREATE TABLE $TABLE_NAME " +
                        "(" +
                        "$PROVIDER_ID STRING PRIMARY KEY NOT NULL," +
                        "$NAME TEXT NOT NULL" +
                        "); "
    }

    object FeedsTable {
        const val TABLE_NAME = "feeds"

        const val FEED_ID = "feed_id"
        const val CITY = "city"
        const val CREATED = "created"
        const val DESCRIPTION = "description"
        const val PROVIDER = "provider"
        const val PROVIDERLINK = "providerLink"

        const val CREATE =
                "CREATE TABLE $TABLE_NAME " +
                        "(" +
                        "$FEED_ID STRING PRIMARY KEY NOT NULL," +
                        "$CITY TEXT NOT NULL," +
                        "$CREATED TEXT NOT NULL," +
                        "$DESCRIPTION TEXT NOT NULL," +
                        "$PROVIDER TEXT NOT NULL," +
                        "$PROVIDERLINK TEXT" +
                        "); "
    }
}