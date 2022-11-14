package yellow.sun.dev.weather.module

import org.koin.dsl.module
import yellow.sun.dev.weather.data.BasicApi

val apiModule = module {
    single {
        NetworkModule.build().create(BasicApi::class.java)
    }
}