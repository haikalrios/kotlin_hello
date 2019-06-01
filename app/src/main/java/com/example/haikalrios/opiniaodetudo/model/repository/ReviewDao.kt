package com.example.haikalrios.opiniaodetudo.model.repository

import android.arch.persistence.room.*
import com.example.haikalrios.opiniaodetudo.model.Review

@Dao
interface ReviewDao {

    object ReviewTableInfo{
        const val TABLE_NAME = "Review"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_REVIEW = "review"
    }

    @Insert
    fun save(review: Review)

    @Query("SELECT * from ${ReviewTableInfo.TABLE_NAME}")
    fun listAll(): List<Review>

    @Delete
    fun delete(review: Review);

    @Update
    fun update(review: Review)

}