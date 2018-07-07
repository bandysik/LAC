package lac.feature.main.app.cache.mapper

import lac.core.feature.core.clean.mapper.CacheMapper
import lac.feature.main.app.cache.model.CacheFeed
import lac.feature.main.app.data.model.DataFeed

class CacheFeedMapper : CacheMapper<CacheFeed, DataFeed> {
    override fun mapFromCached(type: CacheFeed): DataFeed {
        return DataFeed(type.id, type.content)
    }

    override fun mapToCached(type: DataFeed): CacheFeed {
        return CacheFeed(type.id, type.content)
    }
}