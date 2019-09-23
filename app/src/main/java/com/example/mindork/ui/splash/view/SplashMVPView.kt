package com.example.mindork.ui.splash.view

import com.example.mindork.ui.base.view.MVPView

interface SplashMVPView : MVPView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openMainActivity()
    fun openLoginActivity()
}