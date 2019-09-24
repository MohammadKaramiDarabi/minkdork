package com.example.mindork.ui.login

import com.example.mindork.ui.login.interactor.LoginInteractor
import com.example.mindork.ui.login.interactor.LoginMVPInteractor
import com.example.mindork.ui.login.presenter.LoginMVPPresenter
import com.example.mindork.ui.login.presenter.LoginPresenter
import com.example.mindork.ui.login.view.LoginMVPView
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMVPInteractor =
        interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>):
            LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = presenter

}