package com.example.kotlinmvpdemo.persenter

import com.example.kotlinmvpdemo.model.LoginModel
import com.example.kotlinmvpdemo.view.IBaseView
import com.example.kotlinmvpdemo.view.ILoginView

class LoginPersenter(view : ILoginView) :ILoginPersenter {
    lateinit var view:ILoginView
    var loginModel : LoginModel
    init {
        this.view = view
        loginModel = LoginModel(this)
    }

    override fun attchView(baseView: IBaseView) {
        view = baseView as ILoginView
    }

    override fun detach() {
        view == null
    }

    override fun login(userName: String, password: String) {
        view.isShowDialog(true)
        loginModel.login(userName,password)
    }

    override fun loginSucc() {
        view.dissMissDialog()
        view.jumpToDownloadView()
    }

    override fun loginFail(msg: String) {
        view.dissMissDialog()
        view.showToastMessage(msg)
    }


}