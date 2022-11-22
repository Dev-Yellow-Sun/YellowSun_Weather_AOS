package yellow.sun.dev.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import yellow.sun.dev.weather.data.BasicApi
import yellow.sun.dev.weather.data.local.dao.WeatherNowDao
import yellow.sun.dev.weather.repository.WeatherRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
object WeatherRepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideWeatherRepository(basicApi: BasicApi, weatherNowDao: WeatherNowDao) = WeatherRepository(basicApi, weatherNowDao)
}