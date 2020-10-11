package com.common.weikaiyun.retrofit

import com.common.weikaiyun.retrofit.header.CustomHeader
import com.common.weikaiyun.retrofit.okhttp.OkHttpClientManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetWorkManager {
    val commonHeaders = ArrayList<CustomHeader>()
    private val client = OkHttpClientManager.okHttpClient

    //此处可以使用多url，只要每次baseUrl不同即可
    private fun retrofit(baseUrl : String) : Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val wanAndroidRetrofit by lazy {
        retrofit("https://www.wanandroid.com/")
    }
}