package lac.feature.main.app.data.mapper

import lac.core.feature.core.clean.mapper.DataMapper
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.domain.model.Provider

class DataProviderMapper : DataMapper<DataProvider, Provider> {
    override fun mapFromEntity(type: DataProvider): Provider {
        return Provider(type.id, type.content)
    }

    override fun mapToEntity(type: Provider): DataProvider {
        return DataProvider(type.id, type.name)
    }
}