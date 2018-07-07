package lac.feature.main.app.data.mapper

import lac.core.feature.core.clean.mapper.DataMapper
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.domain.model.Bookmark

class DataBookmarkMapper : DataMapper<DataBookmark, Bookmark> {
    override fun mapFromEntity(type: DataBookmark): Bookmark {
        return Bookmark(type.id, type.content)
    }

    override fun mapToEntity(type: Bookmark): DataBookmark {
        return DataBookmark(type.id, type.content)
    }
}