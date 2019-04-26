package com.example.kotlinmvpdemo.view

//通知activity/fragment 进行view的显示
interface IBaseView {
    //是否显示dialog
    fun isShowDialog(isShow : Boolean)

    //显示Toast
    fun showToastMessage(message:String)

    //关闭dialog
    fun dissMissDialog()


}