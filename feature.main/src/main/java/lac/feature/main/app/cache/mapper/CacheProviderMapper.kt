package lac.feature.main.app.cache.mapper

import lac.core.feature.core.clean.mapper.CacheMapper
import lac.feature.main.app.cache.model.CacheProvider
import lac.feature.main.app.data.model.DataProvider

class CacheProviderMapper : CacheMapper<CacheProvider, DataProvider> {
    override fun mapFromCached(type: CacheProvider): DataProvider {
        return DataProvider(type.id, type.content)
    }

    override fun mapToCached(type: DataProvider): CacheProvider {
        return CacheProvider(type.id, type.content)
    }
}