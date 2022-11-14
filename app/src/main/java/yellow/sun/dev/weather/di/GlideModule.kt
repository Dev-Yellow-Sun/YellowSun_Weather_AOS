package yellow.sun.dev.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import yellow.sun.dev.weather.data.BasicApi
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object GlideModule {
//
//    @Provides
//    @Singleton
//    fun okhttpAppGlide(okHttpClient: OkHttpClient) = OkHttpAppGlideModule(okHttpClient)
//}