package com.example.mindork.data.preference

import com.example.mindork.util.AppConstants

interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getCurrentUserId(): Long?

    fun setCurrentUserId(userId: Long?)

    fun getCurrentUsername(): String

    fun setCurrentUsername(username: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(userEmail: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

}