package com.common.weikaiyun.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.weikaiyun.demo.model.UserModel
import com.common.weikaiyun.demo.model.network.bean.User
import com.common.weikaiyun.retrofit.safecall.Result
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val model = UserModel()
    val userLiveData: MutableLiveData<User> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun register(userName: String, password: String, rePassword: String) {
        viewModelScope.launch {
            when(val result = model.register(userName, password, rePassword)) {
                is Result.Success -> {
                    userLiveData.value = result.data
                }

                is Result.Error -> {
                    errorLiveData.value = "请求失败"
                }
            }
        }
    }

    fun login(userName: String, password: String) {
        viewModelScope.launch {
            when(val result = model.login(userName, password)) {
                is Result.Success -> {
                    userLiveData.value = result.data
                }

                is Result.Error -> {
                    errorLiveData.value = "请求失败"
                }
            }
        }
    }
}