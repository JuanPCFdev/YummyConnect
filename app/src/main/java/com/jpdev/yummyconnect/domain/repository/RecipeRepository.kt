package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Recipe

interface RecipeRepository {
    suspend fun addRecipe(recipe: Recipe)
    suspend fun getRecipesByUserId(userId: String): List<Recipe>
    suspend fun deleteRecipe(recipeId: String)
}