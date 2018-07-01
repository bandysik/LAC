package lac.feature.main.domain.repository

import io.reactivex.Observable
import lac.feature.main.domain.model.City

interface CityRepository {
    fun getCities(): Observable<HashMap<String, City>>
}