package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(userId: String): List<Recipe>
    suspend fun createRecipe(recipe: Recipe)
}