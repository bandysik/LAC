package lac.feature.main.app.remote.mapper

import lac.core.feature.core.clean.mapper.RemoteMapper
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.remote.model.RemoteCity

class RemoteCityMapper : RemoteMapper<RemoteCity, DataCity> {
    override fun mapFromRemote(type: RemoteCity): DataCity {
        return DataCity(type.id, type.content)
    }
}