package lac.feature.main.app.remote

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.data.repository.MainRemote
import lac.feature.main.app.remote.mapper.RemoteCityMapper
import lac.feature.main.app.remote.mapper.RemoteFeedMapper
import lac.feature.main.app.remote.mapper.RemoteProviderMapper
import lac.feature.main.app.remote.model.RemoteCity

class MainRemoteImpl(private val mainService: MainService,
                     private val remoteCityMapper: RemoteCityMapper,
                     private val remoteFeedMapper: RemoteFeedMapper,
                     private val remoteProviderMapper: RemoteProviderMapper) : MainRemote {

    override fun getCities(): Single<List<DataCity>> {
        return mainService.getCities()
            .map { response ->
                val itemsMapType = object : TypeToken<Map<String, RemoteCity>>() {}.type
                val gson = Gson().fromJson<Map<String, RemoteCity>>(response, itemsMapType)
                val keys = gson.keys
                keys.map {it->
                    val remoteCity = gson[it]!!
                    remoteCityMapper.mapFromRemote(remoteCity)
                }
            }
    }

    override fun getProviders(): Single<List<DataProvider>> {
        return mainService.getProviders()
            .map {
                it.providers.map { listItem ->
                    remoteProviderMapper.mapFromRemote(listItem)
                }
            }
    }

    override fun getFeeds(): Single<List<DataFeed>> {
        return mainService.getFeeds()
            .map {
                it.feeds.map { listItem ->
                    remoteFeedMapper.mapFromRemote(listItem)
                }
            }
    }
}