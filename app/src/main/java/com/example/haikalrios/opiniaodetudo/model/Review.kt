package com.example.haikalrios.opiniaodetudo.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity
data class Review(
        @PrimaryKey
        val id: String,
        val name: String,
        val review: String?) : Serializable