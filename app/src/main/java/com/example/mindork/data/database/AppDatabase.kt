package com.example.mindork.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mindork.data.database.repository.options.Option
import com.example.mindork.data.database.repository.options.OptionDao
import com.example.mindork.data.database.repository.questions.Question
import com.example.mindork.data.database.repository.questions.QuestionsDao

@Database(entities = [Question::class, Option::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionsDao

    abstract fun optionDao(): OptionDao
}