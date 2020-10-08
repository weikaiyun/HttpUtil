package com.common.weikaiyun.retrofit.okhttp

import com.common.weikaiyun.demo.DemoApplication
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

object OkHttpClientManager {
    private val loggingInterceptor =  HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val okHttpClient = createOkHttpClient(CustomInterceptor(), loggingInterceptor)

    private fun createOkHttpClient(
        vararg interceptors: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        var httpCache: File? = DemoApplication.instance.getExternalFilesDir("httpCache")
        if (httpCache == null) {
            val cacheDir: File = DemoApplication.instance.cacheDir
            httpCache = File(cacheDir, "httpCache")
        }
        builder.cache(Cache(httpCache, 100 * 1024 * 1024))
        builder.connectTimeout(5, TimeUnit.SECONDS)
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
        for (interceptor in interceptors) {
            builder.addInterceptor(interceptor)
        }

        //此处需添加证书处理, cert_file放在asset目录下即可
        //val inputStream = DemoApplication.instance.assets.open("cert_file")
        //val sslParams = HttpsUtil.getSslSocketFactory(Array(1) { inputStream }, null, null)
        val sslParams = HttpsUtil.getSslSocketFactory()
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)

        return builder.build()
    }
}