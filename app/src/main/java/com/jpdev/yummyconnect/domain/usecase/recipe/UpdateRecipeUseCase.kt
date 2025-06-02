package com.jpdev.yummyconnect.domain.usecase.recipe

import com.jpdev.yummyconnect.domain.model.Recipe
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class UpdateRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend operator fun invoke(recipe: Recipe) {
        recipeRepository.updateRecipe(recipe)
    }
}