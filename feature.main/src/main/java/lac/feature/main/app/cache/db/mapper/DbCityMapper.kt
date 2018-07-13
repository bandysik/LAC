package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.model.CacheCity

class DbCityMapper : ModelDbMapper<CacheCity> {
    override fun toContentValues(model: CacheCity): ContentValues {
        val values = ContentValues()
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheCity {
        val id = ""
        val content = ""
        return CacheCity(id, content)
    }
}