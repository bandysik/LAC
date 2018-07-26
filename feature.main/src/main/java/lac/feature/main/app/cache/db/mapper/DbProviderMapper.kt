package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.db.Db
import lac.feature.main.app.cache.model.CacheProvider

class DbProviderMapper : ModelDbMapper<CacheProvider> {
    override fun toContentValues(model: CacheProvider): ContentValues {
        val values = ContentValues()
        values.put(Db.ProvidersTable.PROVIDER_ID, model.id)
        values.put(Db.ProvidersTable.NAME, model.content)
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheProvider {
        val id = cursor.getString(cursor.getColumnIndexOrThrow(Db.ProvidersTable.PROVIDER_ID))
        val content = cursor.getString(cursor.getColumnIndexOrThrow(Db.ProvidersTable.NAME))
        return CacheProvider(id, content)
    }
}