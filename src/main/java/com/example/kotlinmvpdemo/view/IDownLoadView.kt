package com.example.kotlinmvpdemo.view

import android.graphics.Bitmap

//下载的view
interface IDownLoadView :IBaseView{
    //下载图片完成后  view就去加载这个图片
    fun showImage(bitmap: Bitmap?)
}