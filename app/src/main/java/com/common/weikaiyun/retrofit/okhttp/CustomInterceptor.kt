package com.common.weikaiyun.retrofit.okhttp

import com.common.weikaiyun.retrofit.NetWorkManager
import com.common.weikaiyun.retrofit.header.CustomHeader
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        NetWorkManager.headerGenerator?.apply {
            val headers: List<CustomHeader> = generateHeaders()
            for ((name, value) in headers) {
                builder.addHeader(name, value)
            }
        }

        val realRequest = builder.build()

        return chain.proceed(realRequest)
    }
}