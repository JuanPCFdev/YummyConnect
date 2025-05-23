package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.local.dao.RecipeDao
import com.jpdev.yummyconnect.data.local.mapper.toDomain
import com.jpdev.yummyconnect.data.local.mapper.toEntity
import com.jpdev.yummyconnect.data.remote.firebase.FirestoreService
import com.jpdev.yummyconnect.data.remote.mapper.toDomain
import com.jpdev.yummyconnect.data.remote.mapper.toDto
import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao,
    private val firestore: FirestoreService
): RecipeRepository {
    override suspend fun getRecipes(userId: String): List<Recipe> {
        val local = recipeDao.getRecipesForUser(userId).map { it.toDomain(emptyList(), emptyList()) }
        if (local.isNotEmpty()) return local
        val remote = firestore.getRecipesForUser(userId).map { it.toDomain() }
        remote.forEach { recipeDao.insertRecipe(it.toEntity()) }
        return remote
    }

    override suspend fun createRecipe(recipe: Recipe) {
        firestore.saveRecipe(recipe.toDto())
        recipeDao.insertRecipe(recipe.toEntity())
    }
}