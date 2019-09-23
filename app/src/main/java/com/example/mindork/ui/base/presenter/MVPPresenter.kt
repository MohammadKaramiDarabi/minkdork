package com.example.mindork.ui.base.presenter

import com.example.mindork.ui.base.interactor.MVPInteractor
import com.example.mindork.ui.base.view.MVPView

interface MVPPresenter<V: MVPView, I : MVPInteractor> {
    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}