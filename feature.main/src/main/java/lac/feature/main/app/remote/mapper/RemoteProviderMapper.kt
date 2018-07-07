package lac.feature.main.app.remote.mapper

import lac.core.feature.core.clean.mapper.RemoteMapper
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.remote.model.RemoteProvider

class RemoteProviderMapper : RemoteMapper<RemoteProvider, DataProvider> {
    override fun mapFromRemote(type: RemoteProvider): DataProvider {
        return DataProvider(type.id, type.content)
    }
}