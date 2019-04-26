package com.example.kotlinmvpdemo

import android.app.Activity
import android.os.Bundle
import com.example.kotlinmvpdemo.persenter.BasePerseter
import com.example.kotlinmvpdemo.view.IBaseView
import com.example.kotlinmvpdemo.view.ILoginView

abstract class BaseActivity<T : BasePerseter> : Activity(),IBaseView{

    var mPresenter : T? = null
    abstract fun createView():Int
    abstract fun createPresenter():T
    abstract fun viewCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createView())

        mPresenter = createPresenter()
        if(mPresenter != null){
            mPresenter!!.attchView(this)
        }

        viewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mPresenter != null) {
            mPresenter!!.detach()
        }
    }

}