package yellow.sun.dev.weather.data.local.weather.now

import androidx.room.Database
import androidx.room.RoomDatabase
import yellow.sun.dev.weather.data.local.dao.WeatherNowDao

@Database(entities = [WeatherNow::class], version = 1, exportSchema = false)
abstract class WeatherDataBase: RoomDatabase() {
    abstract fun weatherDAO(): WeatherNowDao
}