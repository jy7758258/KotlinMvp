package com.example.kotlinmvpdemo.model

import android.text.TextUtils
import com.example.kotlinmvpdemo.persenter.ILoginPersenter
import com.example.kotlinmvpdemo.persenter.LoginPersenter
import java.lang.Exception

class LoginModel(loginPersenter: ILoginPersenter) : ILoginModel {

    lateinit var loginPersenter : ILoginPersenter
    init {
        this.loginPersenter = loginPersenter
    }
    override fun login(userName: String, password: String) {

        object : Thread(){
            override fun run() {
                try {
                    judgeUserNameAndPassword(userName,password)
                    Thread.sleep(3000)
                    dealLogin(userName,password)
                }catch (e:Exception){
                    e.printStackTrace()
                }

            }
        }.start()

    }

    fun judgeUserNameAndPassword(userName: String, password: String){
        if(TextUtils.isEmpty(userName)){
            loginPersenter.loginFail("请输入账号")
            return
        }
        if(TextUtils.isEmpty(password)){
            loginPersenter.loginFail("请输入密码")
            return
        }

    }

    fun dealLogin(userName: String, password: String){

        if(userName.equals("111111") && password.equals("111111")){
            loginPersenter.loginSucc()
            return
        }else{
            loginPersenter.loginFail("请输入正确的帐号或密码")
        }
    }
}