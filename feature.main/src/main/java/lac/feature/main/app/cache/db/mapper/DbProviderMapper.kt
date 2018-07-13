package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.model.CacheProvider

class DbProviderMapper : ModelDbMapper<CacheProvider> {
    override fun toContentValues(model: CacheProvider): ContentValues {
        val values = ContentValues()
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheProvider {
        val id = ""
        val content = ""
        return CacheProvider(id, content)
    }
}