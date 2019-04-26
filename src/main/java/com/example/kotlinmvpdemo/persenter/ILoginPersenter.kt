package com.example.kotlinmvpdemo.persenter

import com.example.kotlinmvpdemo.view.ILoginView

interface ILoginPersenter :BasePerseter{
    //调用model去登录
    fun login(userName:String,password:String)

    //登录成功
    fun loginSucc()

    //登录失败
    fun loginFail(msg:String)
}