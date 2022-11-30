package yellow.sun.dev.weather.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yellow.sun.dev.weather.data.repository.MyServiceRepository
import yellow.sun.dev.weather.ui.activity.MyService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MyModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(impl: MyServiceRepository): MyService

}

