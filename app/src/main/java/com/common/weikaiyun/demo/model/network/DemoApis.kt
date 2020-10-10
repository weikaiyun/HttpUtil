package com.common.weikaiyun.demo.model.network

import com.common.weikaiyun.demo.model.network.bean.User
import com.common.weikaiyun.retrofit.netbean.NetBean
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface DemoApis {
    @POST("user/register")
    suspend fun register(@Query("username") userName: String,
                         @Query("password") password: String,
                         @Query("repassword") rePassword: String): Response<NetBean<User>>

    @POST("user/login")
    suspend fun login(@Query("username") userName: String,
                      @Query("password") password: String): Response<NetBean<User>>
}