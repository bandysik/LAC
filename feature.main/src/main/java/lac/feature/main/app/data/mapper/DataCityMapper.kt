package lac.feature.main.app.data.mapper

import lac.core.feature.core.clean.mapper.DataMapper
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.domain.model.City

class DataCityMapper : DataMapper<DataCity, City> {
    override fun mapFromEntity(type: DataCity): City {
        return City(type.id, type.content)
    }

    override fun mapToEntity(type: City): DataCity {
        return DataCity(type.code, type.name)
    }
}