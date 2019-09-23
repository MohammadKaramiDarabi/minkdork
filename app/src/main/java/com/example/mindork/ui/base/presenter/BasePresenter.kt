package com.example.mindork.ui.base.presenter

import com.example.mindork.ui.base.interactor.MVPInteractor
import com.example.mindork.ui.base.view.MVPView

abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor() :
    MVPPresenter<V, I> {

}