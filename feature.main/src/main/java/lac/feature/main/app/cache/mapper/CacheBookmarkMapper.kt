package lac.feature.main.app.cache.mapper

import lac.core.feature.core.clean.mapper.CacheMapper
import lac.feature.main.app.cache.model.CacheBookmark
import lac.feature.main.app.data.model.DataBookmark

class CacheBookmarkMapper : CacheMapper<CacheBookmark, DataBookmark> {
    override fun mapFromCached(type: CacheBookmark): DataBookmark {
        return DataBookmark(type.id, type.content)
    }

    override fun mapToCached(type: DataBookmark): CacheBookmark {
        return CacheBookmark(type.id, type.content)
    }
}