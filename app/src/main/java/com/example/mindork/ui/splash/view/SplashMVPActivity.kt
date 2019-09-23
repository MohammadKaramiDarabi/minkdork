package com.example.mindork.ui.splash.view

import android.content.Intent
import android.os.Bundle
import com.example.mindork.R
import com.example.mindork.ui.base.view.BaseActivity
import com.example.mindork.ui.login.view.LoginActivity
import com.example.mindork.ui.main.ui.MainActivity
import com.example.mindork.ui.splash.inetactor.SplashMVPInteractor
import com.example.mindork.ui.splash.presenter.SplashMVPPresenter
import javax.inject.Inject

class SplashMVPActivity : BaseActivity(), SplashMVPView {

    @Inject
    lateinit var presenter: SplashMVPPresenter<SplashMVPView,SplashMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun showSuccessToast() {}

    override fun showErrorToast() {}

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}
}
