package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.db.Db
import lac.feature.main.app.cache.model.CacheBookmark

class DbBookmarkMapper : ModelDbMapper<CacheBookmark> {
    override fun toContentValues(model: CacheBookmark): ContentValues {
        val values = ContentValues()
        values.put(Db.BookmarkTable.CONTENT, model.content)
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheBookmark {
        val id = ""
        val content = cursor.getString(cursor.getColumnIndexOrThrow(Db.BookmarkTable.CONTENT))
        return CacheBookmark(id, content)
    }
}