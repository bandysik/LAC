package lac.feature.main.app.domain.repository

import io.reactivex.Observable
import lac.feature.main.app.domain.model.City
import lac.feature.main.app.domain.model.Feed

interface MainRepository {
    fun getCities(): Observable<HashMap<String, City>>
    fun getProviders(): Observable<HashMap<String, City>>
    fun getFeed(): Observable<HashMap<String, Feed>>
}