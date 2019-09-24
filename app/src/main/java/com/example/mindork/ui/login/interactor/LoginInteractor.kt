package com.example.mindork.ui.login.interactor

import com.example.mindork.data.network.ApiHelper
import com.example.mindork.data.network.LoginRequest
import com.example.mindork.data.network.LoginResponse
import com.example.mindork.data.preference.PreferenceHelper
import com.example.mindork.ui.base.interactor.BaseInteractor
import com.example.mindork.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class LoginInteractor @Inject constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper)
    : BaseInteractor(preferenceHelper, apiHelper), LoginMVPInteractor {

    override fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse> =
        apiHelper.performServerLogin(
            LoginRequest.ServerLoginRequest(email = email, password = password)
        )


    override fun doFBApiCall(): Observable<LoginResponse> =
        apiHelper.performFBLogin(LoginRequest.FacebookLoginRequest("test1", "test1"))

    override fun doGoogleApiCall(): Observable<LoginResponse> =
        apiHelper.performGoogleLogin(LoginRequest.GoogleLoginRequest("test2", "test2"))

    override fun updateUserInSharedPref(
        loginResponse: LoginResponse,
        loggedInMode: AppConstants.LoggedInMode
    ) = preferenceHelper.let {
        it.setCurrentUserId(loginResponse.userId)
        it.setAccessToken(loginResponse.accessToken)
        it.setCurrentUserLoggedInMode(loggedInMode)
    }

}