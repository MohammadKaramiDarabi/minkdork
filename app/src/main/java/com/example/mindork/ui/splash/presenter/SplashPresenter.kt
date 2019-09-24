package com.example.mindork.ui.splash.presenter

import android.os.CountDownTimer
import com.example.mindork.ui.base.presenter.BasePresenter
import com.example.mindork.ui.splash.inetactor.SplashMVPInteractor
import com.example.mindork.ui.splash.view.SplashMVPView
import com.example.mindork.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter <V: SplashMVPView, I: SplashMVPInteractor> @Inject constructor(
    interactor: I?,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
): BasePresenter<V, I>(interactor,schedulerProvider,compositeDisposable), SplashMVPPresenter<V,I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)

        object :CountDownTimer(3000,3000){
            override fun onFinish() {
                feedInDatabase()
            }

            override fun onTick(millisUntilFinished: Long) {

            }

        }.start()

    }

    private fun feedInDatabase() = interactor?.let {
        compositeDisposable.add(it.seedQeustions()
            .flatMap { interactor?.seedOptions()}
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe {
                getView()?.let {
                    decideActivityToOpen()
                }
            }
        )
    }

    private fun decideActivityToOpen() = getView()?.let {
        if (isUserLoggedIn())
            it.openLoginActivity()
        else
            it.openLoginActivity()
    }

    private fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }

}