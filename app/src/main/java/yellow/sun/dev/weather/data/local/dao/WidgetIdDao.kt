package yellow.sun.dev.weather.data.local.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import yellow.sun.dev.weather.data.local.widget.WidgetId

@Dao
interface WidgetIdDao {

    @Query("SELECT * FROM widget_id")
    fun getWidgetId(): Flowable<List<WidgetId>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWidgetId(vararg id: WidgetId):Completable

    @Update
    fun updateWidgetId(id: WidgetId): Completable

    @Delete
    fun deleteWidgetId(id: WidgetId): Completable

    @Query("DELETE FROM widget_id")
    fun deleteAll(): Completable

}