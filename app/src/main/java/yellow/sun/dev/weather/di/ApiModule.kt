package yellow.sun.dev.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import yellow.sun.dev.weather.data.BasicApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun baseApi(retrofit: Retrofit): BasicApi = retrofit.create(BasicApi::class.java)
}