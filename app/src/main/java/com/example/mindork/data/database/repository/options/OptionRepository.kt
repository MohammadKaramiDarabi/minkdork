package com.example.mindork.data.database.repository.options

import io.reactivex.Observable
import io.reactivex.Single

class OptionRepository(private val optionDao: OptionDao) : OptionRepo {

    override fun isOptionsRepoEmpty(): Observable<Boolean> =
        Observable.just(optionDao.loadAll().isEmpty())


    override fun insertOptions(options: List<Option>): Observable<Boolean> {
        optionDao.insertAll(options)
        return Observable.just(true)
    }

    override fun loadOptions(questionId: Long): Single<List<Option>> =
        Single.fromCallable { optionDao.loadOptionByQuestionId(questionId) }

}