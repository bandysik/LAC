package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.db.Db
import lac.feature.main.app.cache.model.CacheFeed

class DbFeedMapper : ModelDbMapper<CacheFeed> {
    override fun toContentValues(model: CacheFeed): ContentValues {
        val values = ContentValues()
        values.put(Db.FeedsTable.FEED_ID, model.id)
        values.put(Db.FeedsTable.CITY, model.city)
        values.put(Db.FeedsTable.CREATED, model.created)
        values.put(Db.FeedsTable.DESCRIPTION, model.description)
        values.put(Db.FeedsTable.PROVIDER, model.provider)
        values.put(Db.FeedsTable.PROVIDERLINK, model.providerLink)
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheFeed {
        val id = cursor.getString(cursor.getColumnIndexOrThrow(Db.FeedsTable.FEED_ID))
        val city = cursor.getString(cursor.getColumnIndexOrThrow(Db.FeedsTable.CITY))
        val created = cursor.getString(cursor.getColumnIndexOrThrow(Db.FeedsTable.CREATED))
        val description = cursor.getString(cursor.getColumnIndexOrThrow(Db.FeedsTable.DESCRIPTION))
        val provider = cursor.getString(cursor.getColumnIndexOrThrow(Db.FeedsTable.PROVIDER))
        val providerLink = cursor.getString(cursor.getColumnIndexOrThrow(Db.FeedsTable.PROVIDERLINK))
        return CacheFeed(id, city, created, description, provider, providerLink)
    }
}