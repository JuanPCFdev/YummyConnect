package com.jpdev.yummyconnect.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val title: String,
    val description: String,
    val preparationTime: Int,
    val servings: Int,
    val difficulty: String,
    val isVegetarian: Boolean
)