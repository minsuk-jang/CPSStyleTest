package com.example.data.interceptor

import com.example.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


class KaKaoInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "KakaoAK ${BuildConfig.API_KEY}")
            .build()

        return chain.proceed(request)
    }
}