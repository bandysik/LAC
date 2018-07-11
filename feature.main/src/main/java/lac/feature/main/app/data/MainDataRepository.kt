package lac.feature.main.app.data

import io.reactivex.Completable
import io.reactivex.Observable
import lac.feature.main.app.data.mapper.DataBookmarkMapper
import lac.feature.main.app.data.mapper.DataCityMapper
import lac.feature.main.app.data.mapper.DataFeedMapper
import lac.feature.main.app.data.mapper.DataProviderMapper
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.source.MainDataStoreFactory
import lac.feature.main.app.data.source.MainRemoteDataStore
import lac.feature.main.app.domain.model.City
import lac.feature.main.app.domain.model.Feed
import lac.feature.main.app.domain.repository.MainRepository

class MainDataRepository(val factory: MainDataStoreFactory,
                         val bookmarkMapper: DataBookmarkMapper,
                         val cityMapper: DataCityMapper,
                         val feedMapper: DataFeedMapper,
                         val providerMapper: DataProviderMapper) : MainRepository {

    override fun getCities(): Observable<HashMap<String, City>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getCities()
            .flatMap {
                if(dataStore is MainRemoteDataStore){
                    saveCities(it).toSingle{it}
                }
            }
    }

    private fun saveCities(cities: List<DataCity>): Completable{
        val citiesEntities=cities.map{cityMapper.mapToEntity(it)}
        factory.retrieveCacheDataStore().putCities(citiesEntities)
        return
    }

    override fun getProviders(): Observable<HashMap<String, City>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFeed(): Observable<HashMap<String, Feed>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}