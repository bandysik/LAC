package lac.feature.main.app.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import lac.feature.main.app.cache.db.Db
import lac.feature.main.app.cache.model.CacheCity

class DbCityMapper : ModelDbMapper<CacheCity> {
    override fun toContentValues(model: CacheCity): ContentValues {
        val values = ContentValues()
        values.put(Db.CitiesTable.CITY_ID, model.id)
        values.put(Db.CitiesTable.NAME, model.content)
        return values
    }

    override fun parseCursor(cursor: Cursor): CacheCity {
        val id = cursor.getString(cursor.getColumnIndexOrThrow(Db.CitiesTable.CITY_ID))
        val content = cursor.getString(cursor.getColumnIndexOrThrow(Db.CitiesTable.NAME))
        return CacheCity(id, content)
    }
}