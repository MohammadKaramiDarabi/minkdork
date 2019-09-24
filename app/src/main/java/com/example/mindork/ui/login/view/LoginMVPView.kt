package com.example.mindork.ui.login.view

import com.example.mindork.ui.base.view.MVPView

interface LoginMVPView: MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}