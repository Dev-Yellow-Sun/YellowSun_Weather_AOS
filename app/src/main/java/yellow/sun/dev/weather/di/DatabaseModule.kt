package yellow.sun.dev.weather.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.config.C
import yellow.sun.dev.weather.data.local.weather.now.WeatherDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideWeatherNowDatabase(
        @ApplicationContext context: Context
    ) =
        Room.databaseBuilder(
            context,
            WeatherDataBase::class.java,
            C.RoomTableName.WEATHER_NOW
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideWeatherNowDAO(dataBase: WeatherDataBase) = dataBase.weatherDAO()

}