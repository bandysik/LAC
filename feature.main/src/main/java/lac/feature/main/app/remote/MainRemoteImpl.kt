package lac.feature.main.app.remote

import io.reactivex.Single
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider
import lac.feature.main.app.data.repository.MainRemote
import lac.feature.main.app.remote.mapper.RemoteCityMapper
import lac.feature.main.app.remote.mapper.RemoteFeedMapper
import lac.feature.main.app.remote.mapper.RemoteProviderMapper

class MainRemoteImpl(val mainService: MainService,
                     val remoteCityMapper: RemoteCityMapper,
                     val remoteFeedMapper: RemoteFeedMapper,
                     val remoteProviderMapper: RemoteProviderMapper) : MainRemote {

    override fun getCities(): Single<List<DataCity>> {
        return mainService.getCities()
            .map {
                it.cities.map { listItem ->
                    remoteCityMapper.mapFromRemote(listItem)
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