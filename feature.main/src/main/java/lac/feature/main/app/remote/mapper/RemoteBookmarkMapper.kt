package lac.feature.main.app.remote.mapper

import lac.core.feature.core.clean.mapper.RemoteMapper
import lac.feature.main.app.data.model.DataBookmark
import lac.feature.main.app.remote.model.RemoteBookmark

class RemoteBookmarkMapper : RemoteMapper<RemoteBookmark, DataBookmark> {
    override fun mapFromRemote(type: RemoteBookmark): DataBookmark {
        return DataBookmark(type.id, type.content)
    }
}