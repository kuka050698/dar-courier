/*
 * Copyright (c) DAR Ecosystem 2018.
 *
 * Created by sough on 15/08/2018.
 */

package kz.darlogistics.courier.auth.login

import kz.darlogistics.courier.auth.AuthContract
import kz.darlogistics.courier.core.util.BasePresenter
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * Presenter that deliver data to LoginView
 */
class LoginPresenter : BasePresenter<AuthContract.LoginView>(), AuthContract.LoginPresenter,KoinComponent {
    private val repository: AuthContract.LoginRepository by inject()
    override fun viewIsReady() {}

    override fun destroy() {}

    override fun loginUser(email: String, pass: String) {
        repository.login(email, pass)
                .subscribe({
                    getView()?.onLoginSuccess()
                    getView()?.showProgress()
                },{
                    getView()?.onLoginError()
                    getView()?.showProgress()
                })
    }

}