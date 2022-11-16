package yellow.sun.dev.weather.data.repository

import com.google.gson.JsonObject
import io.reactivex.Completable
import io.reactivex.Flowable
import org.koin.core.component.KoinComponent
import yellow.sun.dev.weather.config.C
import yellow.sun.dev.weather.data.BasicApi
import yellow.sun.dev.weather.data.local.dao.WeatherNowDao
import yellow.sun.dev.weather.data.local.weather.now.WeatherNow

class WeatherRepository(
    private val baseApi: BasicApi,
    private val weatherNowDao: WeatherNowDao
): KoinComponent {


    /**
     * 기상청 단기 예보 정보 (1일 8회)
     * @param ServiceKey  API KEY
     * @param dataType  JSON, XML
     * @param pageNo  페이지 번호
     * @param numOfRows  한 페이지 결과 수
     * @param base_date  발표일자
     * @param base_time  발표시각  (0210, 0510, 0810, 1110, 1410, 1710, 2010, 2310)
     * @param nx : 예보지점 X 좌표
     * @param ny : 예보지점 Y 좌표
     */
    fun getNow(
        params: Map<String, Any?> = mapOf(),
        header: Map<String, Any?> = mapOf()
    ): Flowable<JsonObject> {
        return baseApi.getApi(
            url = C.WeatherApi.WEATHER_NOW,
            params,
            header
        )
    }

    /**
     * 기상청 초단기 예보 정보
     * @param ServiceKey  API KEY
     * @param dataType  JSON, XML
     * @param pageNo  페이지 번호
     * @param numOfRows  한 페이지 결과 수
     * @param base_date  발표일자
     * @param base_time  발표시각
     * @param nx  예보지점 X 좌표
     * @param ny  예보지점 Y 좌표
     */
    fun getRightNow(
        params: Map<String, Any?> = mapOf(),
        header: Map<String, Any?> = mapOf()
    ): Flowable<JsonObject> {
        return baseApi.getApi(
            url = C.WeatherApi.WEATHER_RIGHT_NOW,
            params,
            header
        )
    }

    /**
     * 기상청 중기 기온 정보
     * @param ServiceKey  API KEY
     * @param dataType  JSON, XML
     * @param pageNo  페이지 번호
     * @param numOfRows  한 페이지 결과 수
     * @param regId  예보구역 코드 (11B10101 서울)
     * @param tmFc  발표시각 (일 2회 06:00 18:00 생성 YYYYMMDD0600(1800))
     */
    fun getWeatherMidTa(
        params: Map<String, Any?> = mapOf(),
        header: Map<String, Any?> = mapOf()
    ): Flowable<JsonObject> {
        return baseApi.getApi(
            url = C.WeatherApi.WEATHER_MID_TA,
            params,
            header
        )
    }

    /**
     * 기상청 중기 육상 예보 정보
     * @param ServiceKey  API KEY
     * @param dataType  JSON, XML
     * @param pageNo  페이지 번호
     * @param numOfRows  한 페이지 결과 수
     * @param regId  예보구역 코드 (11B10101 서울)
     * @param tmFc  발표시각 (일 2회 06:00 18:00 생성 YYYYMMDD0600(1800))
     */
    fun getWeatherMidFcst(
        params: Map<String, Any?> = mapOf(),
        header: Map<String, Any?> = mapOf()
    ): Flowable<JsonObject> {
        return baseApi.getApi(
            url = C.WeatherApi.WEATHER_MID_FCST,
            params,
            header
        )
    }

    /**
     * 로컬에 저장된 날씨 데이터 조회
     */
    fun getLocalWeatherData(): Flowable<List<WeatherNow>> =
        weatherNowDao.getWeatherData()

    /**
     * 로컬에 날씨 데이터 저장
     */
    fun saveLocalWeatherData(vararg weatherNow: WeatherNow): Completable =
        weatherNowDao.insertWeatherData(*weatherNow)

    /**
     * 로컬 날씨 데이터 삭제
     */
    fun deleteLocalWeatherData(data: WeatherNow): Completable =
        weatherNowDao.deleteWeatherData(data)


    /**
     * 로컬 날씨 데이터 삭제
     */
    fun deleteLocalWeatherData(vararg weatherNow: WeatherNow): Completable =
        weatherNowDao.deleteWeatherData(*weatherNow)
}