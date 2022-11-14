package yellow.sun.dev.weather.repository

import com.google.gson.JsonObject
import io.reactivex.Flowable
import yellow.sun.dev.weather.data.BasicApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val basicApi: BasicApi
) {

    fun getWeather(
        params: Map<String, Any?> = mapOf(),
        header: Map<String, Any?> = mapOf()
    ): Flowable<JsonObject> {
        return basicApi.getApi(
            url = "",
            params,
            header
        )
    }
}