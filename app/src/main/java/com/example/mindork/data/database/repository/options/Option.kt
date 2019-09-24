package com.example.mindork.data.database.repository.options

import androidx.room.*
import com.example.mindork.data.database.repository.questions.Question
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(
    tableName = "options",
    foreignKeys = [
        ForeignKey(
            entity = Question::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("question_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Option (
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @SerializedName("option_text")
    @ColumnInfo(name = "Option_text")
    var optionText: String,

    @Expose
    @SerializedName("question_id")
    @ColumnInfo(name = "question_id",index = true)
    var questionId: Long,

    @Expose
    @SerializedName("is_correct")
    @ColumnInfo(name = "is_correct")
    var isCorrect: Boolean,

    @Expose
    @SerializedName("crated_at")
    @ColumnInfo(name = "crated_at")
    var createdAt: String?,

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    var updatedAt: String?
)