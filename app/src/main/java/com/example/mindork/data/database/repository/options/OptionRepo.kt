package com.example.mindork.data.database.repository.options

import io.reactivex.Observable
import io.reactivex.Single


interface OptionRepo {

    fun isOptionsRepoEmpty(): Observable<Boolean>

    fun insertOptions(options: List<Option>): Observable<Boolean>

    fun loadOptions(questionId: Long): Single<List<Option>>
}