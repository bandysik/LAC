package lac.feature.main.app.remote

import io.reactivex.Single
import lac.feature.main.app.remote.model.RemoteCity
import lac.feature.main.app.remote.model.RemoteFeed
import lac.feature.main.app.remote.model.RemoteProvider
import retrofit2.http.GET

interface MainService {

    @GET("cities.json")
    fun getCities(): Single<CitiesResponse>

    class CitiesResponse {
        lateinit var cities: List<RemoteCity>
    }

    @GET("feeds.json")
    fun getFeeds(): Single<FeedsResponse>

    class FeedsResponse {
        lateinit var feeds: List<RemoteFeed>
    }

    @GET("providers.json")
    fun getProviders(): Single<ProvidersResponse>

    class ProvidersResponse {
        lateinit var providers: List<RemoteProvider>
    }
}