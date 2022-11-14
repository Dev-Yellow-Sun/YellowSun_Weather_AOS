package yellow.sun.dev.weather.base

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import yellow.sun.dev.weather.module.apiModule
import yellow.sun.dev.weather.module.viewModelModule

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Koin
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                apiModule,
                viewModelModule
            )
        }
    }
}