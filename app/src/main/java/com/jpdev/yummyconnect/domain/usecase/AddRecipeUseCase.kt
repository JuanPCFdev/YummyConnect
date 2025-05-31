package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class AddRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke(recipe: Recipe) = recipeRepository.addRecipe(recipe)
}