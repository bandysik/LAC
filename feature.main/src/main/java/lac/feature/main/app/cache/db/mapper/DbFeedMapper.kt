package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.model.CacheFeed

class DbFeedMapper : ModelDbMapper<CacheFeed> {
    override fun toContentValues(model: CacheFeed): ContentValues {
        val values = ContentValues()
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheFeed {
        val id = ""
        val content = ""
        return CacheFeed(id, content)
    }
}