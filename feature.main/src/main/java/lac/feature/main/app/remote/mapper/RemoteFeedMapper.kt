package lac.feature.main.app.remote.mapper

import lac.core.feature.core.clean.mapper.RemoteMapper
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.remote.model.RemoteFeed

class RemoteFeedMapper : RemoteMapper<RemoteFeed, DataFeed> {
    override fun mapFromRemote(type: RemoteFeed): DataFeed {
        return DataFeed(type.id, type.content)
    }
}