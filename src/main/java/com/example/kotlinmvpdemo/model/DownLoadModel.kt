package com.example.kotlinmvpdemo.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.util.Log
import com.example.kotlinmvpdemo.persenter.IKotlinDownLoadPersenter
import okhttp3.*
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception

class DownLoadModel(downPersenter: IKotlinDownLoadPersenter) : IKotlinDownLoadModel {
    lateinit var downPersenter: IKotlinDownLoadPersenter

    init {
        this.downPersenter = downPersenter
    }

    override fun downloading(url: String) {

        var okHttpClent = OkHttpClient()

        val request = Request.Builder().url(url).build()
        okHttpClent.newCall(request).enqueue(
                object : Callback {
                    override fun onFailure(call: Call?, e: IOException?) {
                        downPersenter.downloadFail("下载失败")
                    }

                    override fun onResponse(call: Call?, response: Response?) {

                        val inputStream = response!!.body().byteStream()
                        var bitmap: Bitmap = BitmapFactory.decodeStream(inputStream!!)
                        if (bitmap != null) {
                            downPersenter.downloadSucc(bitmap)
                        } else {
                            downPersenter.downloadFail("下载失败")
                        }
                    }

                }
        )
    }


}