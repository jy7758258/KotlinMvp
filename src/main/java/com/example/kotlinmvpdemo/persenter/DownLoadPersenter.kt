package com.example.kotlinmvpdemo.persenter

import android.graphics.Bitmap
import com.example.kotlinmvpdemo.model.DownLoadModel
import com.example.kotlinmvpdemo.view.IBaseView
import com.example.kotlinmvpdemo.view.IDownLoadView

class DownLoadPersenter(view : IDownLoadView): IKotlinDownLoadPersenter{

    lateinit var downModel : DownLoadModel
    override fun attchView(baseView: IBaseView) {
        this.view = baseView as IDownLoadView
        downModel = DownLoadModel(this)
    }

    override fun detach() {
        view == null
    }

    override fun downloading(url: String) {
        view.isShowDialog(true)
        downModel.downloading(url)
    }

    override fun downloadSucc(bitmap: Bitmap) {
        view.dissMissDialog()
        view.showImage(bitmap)
    }

    override fun downloadFail(msg: String) {
        view.dissMissDialog()
        view.showToastMessage(msg)
    }

    var view : IDownLoadView

    init {
        this.view = view
    }
}