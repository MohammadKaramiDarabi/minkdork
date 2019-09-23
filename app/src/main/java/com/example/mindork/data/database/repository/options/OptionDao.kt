package com.example.mindork.data.database.repository.options

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mindork.data.database.repository.questions.Question

@Dao
interface OptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(option: List<Option>)

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    fun loadOptionByQuestionId(questionId: Long): List<Option>

    @Query("SELECT * FROM options")
    fun loadAll(): List<Option>
}