package com.example.mindork.data.database.repository.questions

import io.reactivex.Observable


interface QuestionRepo {

    fun isQuestionRepositotyEmpty(): Observable<Boolean>

    fun insertQuestions(questions: List<Question>): Observable<Boolean>

    fun loadQuestions(): Observable<List<Question>>

}