package com.common.weikaiyun.demo.model

import com.common.weikaiyun.demo.model.network.DemoApis
import com.common.weikaiyun.demo.model.network.bean.User
import com.common.weikaiyun.retrofit.NetWorkManager
import com.common.weikaiyun.retrofit.safecall.Result
import com.common.weikaiyun.retrofit.safecall.SafeApiRequest

class UserModel: SafeApiRequest() {
    suspend fun register(userName: String, password: String, rePassword: String): Result<User> {
        return apiRequest {
            NetWorkManager
                .wanAndroidRetrofit
                .create(DemoApis::class.java)
                .register(userName, password, rePassword)
        }
    }

    suspend fun login(userName: String, password: String): Result<User> {
        return apiRequest {
            NetWorkManager
                .wanAndroidRetrofit
                .create(DemoApis::class.java)
                .login(userName, password)
        }
    }
}