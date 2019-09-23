package com.example.mindork.ui.base.interactor

import com.example.mindork.data.network.ApiHelper
import com.example.mindork.data.preference.PreferenceHelper
import com.example.mindork.util.AppConstants

open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this(){
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn(): Boolean =
        this.preferenceHelper.getCurrentUserLoggedInMode() !=
                AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun performUserLogout() {
        preferenceHelper.let {
            it.setCurrentUserId(null)
            it.setCurrentUserEmail(null)
            it.setAccessToken(null)
            it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
        }
    }

}