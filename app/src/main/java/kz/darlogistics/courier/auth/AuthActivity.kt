/*
 * Copyright (c) DAR Ecosystem 2018.
 *
 * Created by sough on 14/08/2018.
 */

package kz.darlogistics.courier.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*
import kz.darlogistics.courier.R
import kz.darlogistics.courier.orderList.OrderListActivity
import org.koin.android.ext.android.inject

/**
 * Activity that holds all Auth fragments
 */
class AuthActivity() : AppCompatActivity(),AuthContract.LoginView {
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override val presenter: AuthContract.LoginPresenter by inject()
    override fun onLoginSuccess() {
        val intent = Intent(this,OrderListActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onLoginError() {
        Toast.makeText(this,"Login or password incorrect",Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        presenter.attachView(this)
        login_view_login_button.setOnClickListener {
            val pass = passwordInputText.text.toString()
            val email = loginText.text.toString()
            presenter.loginUser(email,pass)
        }
    }

    override fun onStart() {
        super.onStart()

    }
}