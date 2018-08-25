/*
 * Copyright (c) DAR Ecosystem 2018.
 *
 * Created by sough on 15/08/2018.
 */

package kz.darlogistics.courier.auth

import kz.darlogistics.courier.auth.login.LoginPresenter
import kz.darlogistics.courier.auth.login.LoginRepository
import kz.darlogistics.courier.core.api.Constants
import kz.darlogistics.courier.core.createService
import org.koin.dsl.module.module

/**
 * This module provides all AUTH dependencies
 */
val authModule = module {
    factory { LoginPresenter() as AuthContract.LoginPresenter }
    factory {LoginRepository(get()) as AuthContract.LoginRepository }
    single { createService<AuthService>(get(),Constants.url) }
}