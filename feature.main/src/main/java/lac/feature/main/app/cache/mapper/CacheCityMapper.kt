package lac.feature.main.app.cache.mapper

import lac.core.feature.core.clean.mapper.CacheMapper
import lac.feature.main.app.cache.model.CacheCity
import lac.feature.main.app.data.model.DataCity

class CacheCityMapper:CacheMapper<CacheCity,DataCity> {
    override fun mapFromCached(type: CacheCity): DataCity {
        return DataCity(type.id, type.content)
    }

    override fun mapToCached(type: DataCity): CacheCity {
        return CacheCity(type.id, type.content)
    }
}