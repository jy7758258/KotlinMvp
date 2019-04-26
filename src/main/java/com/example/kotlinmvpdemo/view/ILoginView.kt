package com.example.kotlinmvpdemo.view

interface ILoginView:IBaseView {
    //登录成功后 跳转到下载界面
    fun jumpToDownloadView()
}