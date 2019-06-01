package com.example.haikalrios.opiniaodetudo.model.repository

import android.content.Context
import com.example.haikalrios.opiniaodetudo.model.Review
import java.util.*

class ReviewRepository{

    private val reviewDao: ReviewDao

    constructor(context: Context){
        val reviewDatabase = ReviewDatabase.getInstance(context)
        reviewDao = reviewDatabase.reviewDao()
    }

    fun save(name: String, review: String) {
        reviewDao.save(Review(UUID.randomUUID().toString(), name, review))
    }
    fun listAll(): List<Review> {
        return reviewDao.listAll()
    }

    fun delete(review: Review){
        reviewDao.delete(review);

    }

    fun update(id: String, name: String, review: String) {
        reviewDao.update(Review(id, name, review))
    }

    fun update(review:Review) {
        reviewDao.update(review)
    }
}