package com.example.kotlinmvpdemo

import android.app.Activity
import android.app.ProgressDialog
import android.graphics.Bitmap
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.kotlinmvpdemo.persenter.DownLoadPersenter
import com.example.kotlinmvpdemo.view.IDownLoadView

class DownLoadActivity :BaseActivity<DownLoadPersenter>() ,IDownLoadView{

    override fun showImage(bitmap: Bitmap?) {
        runOnUiThread { kotlin.run {  img_view.setImageBitmap(bitmap) } }

    }

    override fun createView(): Int {
        return R.layout.activity_down_load
    }

    override fun createPresenter(): DownLoadPersenter {
        return DownLoadPersenter(this)
    }

    lateinit var img_view : ImageView
    var btn_down : Button? = null
    lateinit var dialog : ProgressDialog
    override fun viewCreated() {

        dialog = ProgressDialog(this)
        dialog.setMessage("正在下载图片···")
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        img_view = findViewById(R.id.img_view)
        btn_down = findViewById(R.id.btn_down)

        btn_down!!.setOnClickListener{
            mPresenter!!.downloading("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556085328964&di=fadb632752d9f72c92a69a5a4dee1a42&imgtype=0&src=http%3A%2F%2Fimg.warting.com%2Fallimg%2F2016%2F0324%2F1-1603241S013.jpg")
        }
    }

    override fun isShowDialog(isShow: Boolean) {
        if(isShow){
            if(dialog != null){
                dialog.show()
            }
        }
    }

    override fun showToastMessage(message: String) {
        runOnUiThread { kotlin.run { Toast.makeText(this,message,Toast.LENGTH_SHORT).show() } }
    }

    override fun dissMissDialog() {
        if(dialog != null && dialog.isShowing){
            dialog.dismiss()
        }
    }
}