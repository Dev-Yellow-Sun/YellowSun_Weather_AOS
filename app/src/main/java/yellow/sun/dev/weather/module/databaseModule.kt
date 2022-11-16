package yellow.sun.dev.weather.module

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import yellow.sun.dev.weather.config.C
import yellow.sun.dev.weather.data.local.weather.now.WeatherDataBase

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            WeatherDataBase::class.java,
            C.RoomTableName.WEATHER_NOW
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<WeatherDataBase>().weatherDAO()
    }
}