package com.common.weikaiyun.demo.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.common.weikaiyun.R
import com.common.weikaiyun.demo.ui.base.BaseSupportActivity
import com.common.weikaiyun.demo.viewmodel.UserViewModel
import com.weikaiyun.fragmentation.SupportHelper

class DemoMainActivity : BaseSupportActivity() {

    override fun getContentViewID(): Int = R.layout.activity_demo_main

    override fun initData(savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.userLiveData.observe(this, {

        })

        viewModel.errorLiveData.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        viewModel.login("lqx", "123456")
    }

    override fun initView(savedInstanceState: Bundle?) {
        var mainFragment = SupportHelper.findFragment(supportFragmentManager, DemoMainFragment::class.java)
        if (mainFragment == null) {
            mainFragment = DemoMainFragment.newInstance()
            loadRootFragment(R.id.container, mainFragment)
        }
    }
}
