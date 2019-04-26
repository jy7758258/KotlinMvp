package com.example.kotlinmvpdemo

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinmvpdemo.persenter.ILoginPersenter
import com.example.kotlinmvpdemo.persenter.LoginPersenter
import com.example.kotlinmvpdemo.view.IBaseView
import com.example.kotlinmvpdemo.view.ILoginView

class LoginActivity : BaseActivity<LoginPersenter>(), ILoginView {
    override fun jumpToDownloadView() {
        val intent : Intent = Intent()
        intent.setClass(this,DownLoadActivity::class.java)
        startActivity(intent)
    }

    override fun createView(): Int {
        return R.layout.activity_login
    }

    override fun createPresenter(): LoginPersenter {
       return LoginPersenter(this)
    }

    var dialog : ProgressDialog? = null
    var et_user: EditText? = null
    var et_pwd: EditText? = null
    var btn_submit: Button? = null
    override fun viewCreated() {
        dialog = ProgressDialog(this)
        dialog!!.setMessage("正在登录中···")
        dialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        et_user = findViewById(R.id.et_user)
        et_pwd = findViewById(R.id.et_pwd)
        btn_submit = findViewById(R.id.btn_submit)
        btn_submit!!.setOnClickListener{
            mPresenter!!.login(et_user!!.text.toString().trim(),et_pwd!!.text.toString().trim())
        }
    }

    override fun isShowDialog(isShow: Boolean) {
        if(isShow){
            if(dialog != null){
                dialog!!.show()
            }
        }
    }

    override fun showToastMessage(message: String) {
        runOnUiThread { kotlin.run {  Toast.makeText(this,message,Toast.LENGTH_SHORT).show() } }

    }

    override fun dissMissDialog() {
        if(dialog != null && dialog!!.isShowing){
            dialog!!.dismiss()
        }
    }

}