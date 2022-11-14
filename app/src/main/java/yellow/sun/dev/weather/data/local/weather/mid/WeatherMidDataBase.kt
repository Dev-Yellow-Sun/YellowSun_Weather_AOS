package yellow.sun.dev.weather.data.local.weather.mid

import androidx.room.Database
import androidx.room.RoomDatabase
import yellow.sun.dev.weather.data.local.dao.WeatherMidDao

@Database(entities = [WeatherMid::class], version = 1, exportSchema = false)
abstract class WeatherMidDataBase: RoomDatabase() {
    abstract fun weatherMidDAO(): WeatherMidDao
}