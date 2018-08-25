/*
 * Copyright (c) DAR Ecosystem 2018.
 *
 * Created by sough on 15/08/2018.
 */

package kz.darlogistics.courier.auth.login

import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_auth.*
import kz.darlogistics.courier.auth.AuthContract
import org.koin.android.ext.android.inject

/**
 * View that allows users to log in
 */
class LoginFragment : Fragment(), AuthContract.LoginView {
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }
    override val presenter: AuthContract.LoginPresenter by inject()

    override fun onLoginSuccess() {
    }

    override fun onLoginError() {
    }
}