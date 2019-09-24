package com.example.mindork.ui.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.mindork.R
import com.example.mindork.ui.base.view.BaseActivity
import com.example.mindork.ui.login.interactor.LoginMVPInteractor
import com.example.mindork.ui.login.presenter.LoginMVPPresenter
import com.example.mindork.ui.main.ui.MainActivity
import com.example.mindork.util.AppConstants
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginMVPView {

    @Inject
    internal lateinit var presenter: LoginMVPPresenter<LoginMVPView, LoginMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)
        setOnClickListenter()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun showValidationMessage(errorCode: Int) = when (errorCode) {
        AppConstants.EMPTY_EMAIL_ERROR -> Toast.makeText(this,"Email cannot be blank",Toast.LENGTH_LONG).show()
        AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(this,"Please enter a valid email address",Toast.LENGTH_LONG).show()
        AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this,"Password cannot be empty",Toast.LENGTH_LONG).show()
        AppConstants.LOGIN_FAILURE -> Toast.makeText(this,"Login failed",Toast.LENGTH_LONG).show()
        else -> Unit
    }

    override fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}

    private fun setOnClickListenter() {

    }
}
