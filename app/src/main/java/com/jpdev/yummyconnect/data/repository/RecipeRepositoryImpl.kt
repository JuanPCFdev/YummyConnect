package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.dto.RecipeDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.data.remote.firestore.FirestoreService
import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val firestoreService: FirestoreService
) : RecipeRepository {

    override suspend fun addRecipe(recipe: Recipe) {
        val dto = recipe.toDto()
        firestoreService.addRecipe(dto)
    }

    override suspend fun getRecipesByUserId(userId: String): List<Recipe> {
        val dtos:List<RecipeDto> = firestoreService.getRecipesByUserId(userId = userId)
        return dtos.map { it.toDomain() }
    }

    override suspend fun deleteRecipe(recipeId: String) {
        firestoreService.deleteRecipe(recipeId = recipeId)
    }
}