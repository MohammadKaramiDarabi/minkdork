package com.example.mindork.ui.splash.inetactor

import android.content.Context
import com.example.mindork.data.database.repository.options.Option
import com.example.mindork.data.database.repository.options.OptionRepo
import com.example.mindork.data.database.repository.questions.Question
import com.example.mindork.data.database.repository.questions.QuestionRepo
import com.example.mindork.data.network.ApiHelper
import com.example.mindork.data.preference.PreferenceHelper
import com.example.mindork.ui.base.interactor.BaseInteractor
import com.example.mindork.util.AppConstants
import com.example.mindork.util.FileUtils
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import io.reactivex.Observable
import java.io.File
import javax.inject.Inject


class SplashInteractor @Inject constructor(
    private val context: Context,
    private val questionRepoHelper: QuestionRepo,
    private val optionRepoHelper: OptionRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper)
    : BaseInteractor(preferenceHelper, apiHelper), SplashMVPInteractor {

    override fun seedQeustions(): Observable<Boolean> {
        val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        return questionRepoHelper.isQuestionRepositotyEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(
                    null,
                    List::class.java,
                    Question::class.java
                )
                val questionList = gson.fromJson<List<Question>>(
                    FileUtils.loadJSONFromAsset(
                        context,
                        AppConstants.SEED_DATABASE_QUESTIONS
                    ),
                    type
                )
                questionRepoHelper.insertQuestions(questionList)
            } else {
            }
            Observable.just(false)
        }
    }

    override fun seedOptions(): Observable<Boolean> {
        val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        return optionRepoHelper.isOptionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`
                    .newParameterizedTypeWithOwner(null, List::class.java, Option::class.java)

                val optionList = gson.fromJson<List<Option>>(
                    FileUtils.loadJSONFromAsset(context, AppConstants.SEED_DATABASE_OPTIONS), type
                )
                optionRepoHelper.insertOptions(optionList)
            } else {
            }
            Observable.just(false)
        }
    }

    override fun getQuestion(): Observable<List<Question>> = questionRepoHelper.loadQuestions()
}