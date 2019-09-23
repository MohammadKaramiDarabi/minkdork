package com.example.mindork.ui.splash

import com.example.mindork.ui.splash.inetactor.SplashInteractor
import com.example.mindork.ui.splash.inetactor.SplashMVPInteractor
import com.example.mindork.ui.splash.presenter.SplashMVPPresenter
import com.example.mindork.ui.splash.presenter.SplashPresenter
import com.example.mindork.ui.splash.view.SplashMVPView
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMVPInteractor =
        splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>)
            : SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> = splashPresenter
}