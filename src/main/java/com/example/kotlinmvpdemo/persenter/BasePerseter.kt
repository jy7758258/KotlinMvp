package com.example.kotlinmvpdemo.persenter

import com.example.kotlinmvpdemo.view.IBaseView

interface BasePerseter {
    fun attchView(baseView : IBaseView)

    fun detach()
}