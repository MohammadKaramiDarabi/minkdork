package com.example.mindork.ui.splash.presenter

import com.example.mindork.ui.base.presenter.MVPPresenter
import com.example.mindork.ui.splash.inetactor.SplashMVPInteractor
import com.example.mindork.ui.splash.view.SplashMVPView

interface SplashMVPPresenter<V: SplashMVPView, I: SplashMVPInteractor> : MVPPresenter<V,I>