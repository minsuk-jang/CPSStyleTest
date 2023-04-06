package com.example.data.module

import android.content.Context
import android.os.Build
import com.example.data.BuildConfig
import com.example.data.BuildConfig.SERVER_URL
import com.example.data.interceptor.KaKaoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val READ_TIME_OUT = 10 * 1000L
const val WRITE_TIME_OUT = 60 * 1000L
const val CONNECT_TIME_OUT = 10 * 1000L

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun getGson() = Gson().newBuilder().setLenient().create()

    @Provides
    @Singleton
    fun getCache(@ApplicationContext context: Context) = Cache(context.cacheDir, 1024 * 1024 * 60L)

    @Provides
    fun getOkhttpClient(
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
            writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
            connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
            cache(cache)

            addInterceptor(KaKaoInterceptor())

            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    @Provides
    fun getRetrofit2(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(SERVER_URL)
            client(client)

            addConverterFactory(GsonConverterFactory.create(gson))
        }.build()
    }
}