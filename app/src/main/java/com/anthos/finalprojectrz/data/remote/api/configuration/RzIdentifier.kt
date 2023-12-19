package com.anthos.finalprojectrz.data.remote.api.configuration

import okhttp3.Interceptor
import okhttp3.Response

class RzIdentifier (private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val requestWithAuthorization = originalRequest.newBuilder()
            .header("Authorization", "Bearer $authToken")
            .build()

        return chain.proceed(requestWithAuthorization)
    }
}