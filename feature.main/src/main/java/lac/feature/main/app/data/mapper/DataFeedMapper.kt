package lac.feature.main.app.data.mapper

import lac.core.feature.core.clean.mapper.DataMapper
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.domain.model.Feed

class DataFeedMapper : DataMapper<DataFeed, Feed> {
    override fun mapFromEntity(type: DataFeed): Feed {
        return Feed(type.id, type.city, type.created, type.description, type.provider, type.providerLink)
    }

    override fun mapToEntity(type: Feed): DataFeed {
        return DataFeed(type.id, type.city, type.created, type.description, type.provider, type.providerLink)
    }
}