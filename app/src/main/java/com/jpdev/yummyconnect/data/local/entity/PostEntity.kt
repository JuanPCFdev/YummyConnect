package com.jpdev.yummyconnect.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val recipeId: String,
    val image: String,
    val timestamp: Long
)