package com.example.mindork.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.mindork.di.PreferenceInfo
import com.example.mindork.util.AppConstants
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(
    context: Context,
    @PreferenceInfo private val prefFileName: String
) : PreferenceHelper {

    companion object {
        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
    }

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode(): Int = mPrefs.getInt(
        PREF_KEY_USER_LOGGED_IN_MODE,
        AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
    )

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) = mPrefs.edit {
        putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type)
    }

    override fun getCurrentUserId(): Long? {
        return when (val userId =
            mPrefs.getLong(
                PREF_KEY_CURRENT_USER_ID,
                AppConstants.NULL_INDEX
            )) {
            AppConstants.NULL_INDEX -> null
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: Long?) {
        val userId = userId ?: AppConstants.NULL_INDEX
        mPrefs.edit { putLong(PREF_KEY_CURRENT_USER_ID, userId) }
    }

    override fun getCurrentUsername(): String =
        mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "ABC") ?: "ABC"

    override fun setCurrentUsername(username: String?) =
        mPrefs.edit { putString(PREF_KEY_CURRENT_USER_NAME, username) }


    override fun getCurrentUserEmail(): String? =
        mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, "ABC@gmail.com") ?: "ABC@gmail.com"

    override fun setCurrentUserEmail(userEmail: String?) =
        mPrefs.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, userEmail) }

    override fun getAccessToken(): String = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "") ?: ""

    override fun setAccessToken(accessToken: String?) =
        mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }
}