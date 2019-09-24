package com.example.mindork.ui.login.presenter

import android.util.Log
import com.example.mindork.data.network.LoginResponse
import com.example.mindork.ui.base.presenter.BasePresenter
import com.example.mindork.ui.login.interactor.LoginMVPInteractor
import com.example.mindork.ui.login.view.LoginMVPView
import com.example.mindork.util.AppConstants
import com.example.mindork.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter<V : LoginMVPView, I : LoginMVPInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable),
    LoginMVPPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else ->{
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(
                        it.doServerLoginApiCall(email,password)
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe(
                            {loginResponse ->
                                updateUserInSharedPref(
                                    loginResponse,
                                    AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER
                                )
                            getView()?.openMainActivity()
                        },
                            {
                            error ->
                            println(error)
                            }
                        )
                    )
                }
            }
        }
    }

    override fun onFBLoginClicked() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doFBApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ loginResponse ->
                    updateUserInSharedPref(loginResponse = loginResponse,
                        loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_FB)
                    getView()?.let {
                        it.hideProgress()
                        it.openMainActivity()
                    }
                }, { err -> println(err) }))
        }


    }

    override fun onGoogleLoginClicked() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doGoogleApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe(
                    { loginResponse ->
                        Log.d("TAG","Response")
                        updateUserInSharedPref(
                            loginResponse = loginResponse,
                            loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE
                        )
                        getView()?.let { view ->
                            view.hideProgress()
                            view.openMainActivity()
                        }
                    },
                    { err -> println(err) }
                )
            )
        }

    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) =
        interactor?.updateUserInSharedPref(loginResponse,loggedInMode)


}