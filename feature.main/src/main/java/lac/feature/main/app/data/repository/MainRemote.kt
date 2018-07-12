package lac.feature.main.app.data.repository

import io.reactivex.Single
import lac.feature.main.app.data.model.DataCity
import lac.feature.main.app.data.model.DataFeed
import lac.feature.main.app.data.model.DataProvider

interface MainRemote {
    fun getCities(): Single<List<DataCity>>

    fun getProviders(): Single<List<DataProvider>>

    fun getFeeds(): Single<List<DataFeed>>
}