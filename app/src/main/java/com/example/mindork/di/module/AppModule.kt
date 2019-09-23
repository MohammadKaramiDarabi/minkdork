package com.example.mindork.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.mindork.BuildConfig
import com.example.mindork.data.database.AppDatabase
import com.example.mindork.data.database.repository.options.OptionRepo
import com.example.mindork.data.database.repository.options.OptionRepository
import com.example.mindork.data.database.repository.questions.QuestionRepo
import com.example.mindork.data.database.repository.questions.QuestionRepositoty
import com.example.mindork.data.network.ApiHelper
import com.example.mindork.data.network.AppApiHelper
import com.example.mindork.data.preference.PreferenceHelper
import com.example.mindork.di.PreferenceInfo
import com.example.mindork.util.AppConstants
import com.example.mindork.data.preference.AppPreferenceHelper
import com.example.mindork.di.ApiKeyInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()


    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo =
        QuestionRepositoty(appDatabase.questionDao())

    @Provides
    @Singleton
    internal fun provideOptionRepoHelper(appDatabase: AppDatabase): OptionRepo =
        OptionRepository(appDatabase.optionDao())

    @Provides
    @PreferenceInfo
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper =
        appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @ApiKeyInfo
    internal fun provideApiKeyInfo(): String = BuildConfig.API_KEY


}