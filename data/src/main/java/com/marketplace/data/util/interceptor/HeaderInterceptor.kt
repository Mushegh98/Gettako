package com.marketplace.data.util.interceptor

import com.marketplace.data.service.preferenceservice.PreferenceService
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
class HeaderInterceptor(private val preferenceService: PreferenceService) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Environment-Info", preferenceService.getToken() ?: "")
            .build()
        return chain.proceed(request)
    }
}