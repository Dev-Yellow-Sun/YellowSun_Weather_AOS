package yellow.sun.dev.weather.data.local.weather.mid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherMid(
    @PrimaryKey(autoGenerate = true)
    var date: Long
)