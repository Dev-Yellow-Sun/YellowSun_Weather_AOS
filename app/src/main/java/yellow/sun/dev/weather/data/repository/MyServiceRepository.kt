package yellow.sun.dev.weather.data.repository

import yellow.sun.dev.weather.ui.activity.MyService
import yellow.sun.dev.weather.utils.L
import javax.inject.Inject
import javax.inject.Singleton

// 인터페이스 구현 class
class MyServiceRepository @Inject constructor(
    private val weatherRepository: WeatherRepository
): MyService {

    override fun getMyMethods(str: String) {
        L.d("@@@@ MyServiceRepository myMethods str:$str")
        weatherRepository.testLog()
    }
}