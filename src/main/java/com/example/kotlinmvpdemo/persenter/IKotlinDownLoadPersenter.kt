package com.example.kotlinmvpdemo.persenter

import android.graphics.Bitmap

//下载
interface IKotlinDownLoadPersenter :BasePerseter{
    //传递给model去下载
    fun downloading(url:String)

    //下载成功 将结果返回
    fun downloadSucc(bitmap: Bitmap)

    //下载失败，返回错误信息
    fun downloadFail(msg:String)

}