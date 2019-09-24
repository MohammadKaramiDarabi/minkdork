package com.example.mindork.ui.login.presenter

import com.example.mindork.ui.base.presenter.BasePresenter
import com.example.mindork.ui.base.presenter.MVPPresenter
import com.example.mindork.ui.login.interactor.LoginMVPInteractor
import com.example.mindork.ui.login.view.LoginMVPView

interface LoginMVPPresenter<V: LoginMVPView, I: LoginMVPInteractor>: MVPPresenter<V,I> {

    fun onServerLoginClicked(email: String, password: String)
    fun onFBLoginClicked()
    fun onGoogleLoginClicked()
}