package yellow.sun.dev.weather.data.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import yellow.sun.dev.weather.data.local.dao.WidgetIdDao
import yellow.sun.dev.weather.data.local.widget.WidgetId

class WidgetIdRepository(
    private val widgetIdDao: WidgetIdDao
) {

    /**
     * 생성된 위젯 ID 조회
     */
    fun getWidgetId() : Flowable<List<WidgetId>> =
            widgetIdDao.getWidgetId()


    /**
     * 위젯 ID 저장
     */
    fun saveWidgetId(vararg id: WidgetId) : Completable =
        widgetIdDao.insertWidgetId(*id)

    /**
     * 위젯 ID 삭제
     */
    fun deleteWidgetId(id: WidgetId) : Completable =
        widgetIdDao.deleteWidgetId(id)
}