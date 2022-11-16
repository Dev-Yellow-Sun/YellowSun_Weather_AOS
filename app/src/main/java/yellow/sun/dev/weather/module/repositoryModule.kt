package yellow.sun.dev.weather.module

import org.koin.dsl.module
import yellow.sun.dev.weather.data.repository.WeatherRepository

val repositoryModule = module {
    factory {
        WeatherRepository(get(), get())
    }

}