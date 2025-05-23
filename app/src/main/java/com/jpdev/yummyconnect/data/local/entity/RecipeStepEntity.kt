package com.jpdev.yummyconnect.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_steps")
data class RecipeStepEntity(
    @PrimaryKey(autoGenerate = true) val localId: Long = 0,
    val recipeId: String,
    val description: String,
    val stepOrder: Int
)