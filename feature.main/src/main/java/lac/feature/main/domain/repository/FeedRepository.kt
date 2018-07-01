package lac.feature.main.domain.repository

import io.reactivex.Observable
import lac.feature.main.domain.model.City

interface FeedRepository {
    fun getProviders(): Observable<HashMap<String, City>>
}