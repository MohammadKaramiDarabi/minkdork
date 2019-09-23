package com.example.mindork.util

object AppConstants {
    internal const val APP_DB_NAME = "mindorks_mvp.db"
    internal const val NULL_INDEX = -1L
    internal const val PREF_NAME = "mindorks_pref"



    enum class LoggedInMode constructor(val type: Int){
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}