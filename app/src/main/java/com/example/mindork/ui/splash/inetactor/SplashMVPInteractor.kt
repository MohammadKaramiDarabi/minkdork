package com.example.mindork.ui.splash.inetactor

import com.example.mindork.data.database.repository.questions.Question
import com.example.mindork.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface SplashMVPInteractor : MVPInteractor {

    fun seedQeustions(): Observable<Boolean>
    fun seedOptions(): Observable<Boolean>
    fun getQuestion(): Observable<List<Question>>

}