package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Recipe

interface RecipeRepository {
    //CRUD
    //Create
    suspend fun addRecipe(recipe: Recipe)
    //Read
    suspend fun getRecipesByUserId(userId: String): List<Recipe>
    //Read one
    suspend fun getRecipeById(id: String): Recipe?
    //Update
    suspend fun updateRecipe(recipe: Recipe)
    //Delete
    suspend fun deleteRecipe(recipeId: String)
}