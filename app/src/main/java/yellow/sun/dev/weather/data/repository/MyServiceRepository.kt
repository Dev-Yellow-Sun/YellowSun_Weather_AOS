package yellow.sun.dev.weather.data.repository

import yellow.sun.dev.weather.ui.activity.MyService
import yellow.sun.dev.weather.utils.L
import javax.inject.Inject
import javax.inject.Singleton

class MyServiceRepository @Inject constructor(): MyService {

    override fun getMyMethods(str: String) {
        L.d("MyServiceRepository myMethods str:$str")
    }
}