package yellow.sun.dev.weather.ui.activity

import android.os.Bundle
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.base.BaseActivity
import yellow.sun.dev.weather.databinding.ActivityMainBinding
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yellow.sun.dev.weather.config.C
import yellow.sun.dev.weather.utils.L
import yellow.sun.dev.weather.utils.getTimeNow
import yellow.sun.dev.weather.utils.getYesterday
import yellow.sun.dev.weather.utils.toast

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        reqWeatherNow(
            C.WeatherData.Location.Seoul["nx"] ?: "",
            C.WeatherData.Location.Seoul["ny"] ?: ""
        )

        viewModel.bindsTest("Hilt Binds")
    }

    /**
     * 기상청 단기 예보 조회
     * 발표 시각 : 0210, 0510, 0810, 1110, 1410, 1710, 2010, 2310
     */
    private fun reqWeatherNow(nx: String, ny: String) {
        var nowDate: String = "YYYYMMdd".getTimeNow()
        val nowHour: String = "HH".getTimeNow()
        val nowTime: String = "HHmm".getTimeNow()
        var baseTime = ""

        kotlin.run {
            C.WeatherData.WEATHER_NOW_GET_DATA_TIME.forEachIndexed { index, item ->
                L.d("reqWeatherNow nowTime : ${nowTime.toInt()}  , item : ${item.toInt()}")
                if (nowHour == "00" || nowHour == "01") {
                    nowDate = "YYYYMMdd".getYesterday()
                    baseTime = "2310"
                    return@run
                } else if (nowTime.toInt() in 200..210){
                    nowDate = "YYYYMMdd".getYesterday()
                    baseTime = "2310"
                    return@run
                } else if (item.toInt() > nowTime.toInt()) {
                    baseTime = C.WeatherData.WEATHER_NOW_GET_DATA_TIME[index-1]
                    L.d("@@@@@@@ baseTime : $baseTime")
                    return@run
                } else {
                    baseTime = nowTime
                }
            }
        }

        baseTime.toast(this)

        viewModel.getNowWeather(
            mapOf(
                "ServiceKey" to C.WeatherApi.API_KEY,
                "dataType" to "JSON",
                "pageNo" to "1",
                "numOfRows" to "1000",
                "base_date" to nowDate,
                "base_time" to baseTime,
                "nx" to nx,
                "ny" to ny
            )
        )
    }


    /**
     * viewModel observe 세팅
     */
    private fun initViewModel() {
        with(viewModel){

            this.isLoading.observe(this@MainActivity) {
                if (it){
                    showLoading()
                } else {
                    hideLoading()
                }
            }

            this.weatherNowJson.observe(this@MainActivity) {
                L.d("weatherNowJson data : $it")
            }
        }
    }

}