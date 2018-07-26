package lac.feature.main.app.remote

import io.reactivex.Single
import lac.feature.main.app.remote.model.RemoteCity
import lac.feature.main.app.remote.model.RemoteFeed
import lac.feature.main.app.remote.model.RemoteProvider
import retrofit2.http.GET

interface MainService {

    @GET("s3st6cnancs3v3g/cities.json?dl=1")
    fun getCities(): Single<CitiesResponse>

    class CitiesResponse {
        lateinit var cities: List<RemoteCity>
    }

    @GET("jfpexw46l6vbdl1/feeds.json?dl=1")
    fun getFeeds(): Single<FeedsResponse>

    class FeedsResponse {
        lateinit var feeds: List<RemoteFeed>
    }

    @GET("d70wos8bq3140gm/providers.json?dl=1")
    fun getProviders(): Single<ProvidersResponse>

    class ProvidersResponse {
        lateinit var providers: List<RemoteProvider>
    }
}