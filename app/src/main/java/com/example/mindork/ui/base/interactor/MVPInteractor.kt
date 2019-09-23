package com.example.mindork.ui.base.interactor

interface MVPInteractor {
    fun isUserLoggedIn(): Boolean
    fun performUserLogout()
}