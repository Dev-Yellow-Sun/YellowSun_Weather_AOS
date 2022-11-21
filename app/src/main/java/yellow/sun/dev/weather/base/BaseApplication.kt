package yellow.sun.dev.weather.base

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import yellow.sun.dev.weather.module.*

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        NetworkModule.context = this

        Stetho.initializeWithDefaults(this)

        // Koin
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                apiModule,
                viewModelModule,
                databaseModule,
                repositoryModule,
                activityModule
            )
        }
    }
}