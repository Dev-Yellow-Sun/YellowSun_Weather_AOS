package yellow.sun.dev.weather.data.local.widget

import androidx.room.Database
import androidx.room.RoomDatabase
import yellow.sun.dev.weather.data.local.dao.WidgetIdDao

@Database(entities = [WidgetId::class], version = 1, exportSchema = false)
abstract class WidgetIdDataBase: RoomDatabase() {
    abstract fun widgetIdDAO(): WidgetIdDao
}