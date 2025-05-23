package com.jpdev.yummyconnect.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true) val localId: Long = 0,
    val recipeId: String,
    val name: String,
    val quantity: String
)