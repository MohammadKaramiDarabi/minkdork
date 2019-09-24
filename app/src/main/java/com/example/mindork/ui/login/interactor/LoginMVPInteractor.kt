package com.example.mindork.ui.login.interactor

import com.example.mindork.data.network.LoginResponse
import com.example.mindork.ui.base.interactor.MVPInteractor
import com.example.mindork.util.AppConstants
import io.reactivex.Observable

interface LoginMVPInteractor : MVPInteractor {

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun doFBApiCall(): Observable<LoginResponse>

    fun doGoogleApiCall(): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)

}