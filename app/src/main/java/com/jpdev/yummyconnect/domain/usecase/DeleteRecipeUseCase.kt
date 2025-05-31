package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class DeleteRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke(id: String) = recipeRepository.deleteRecipe(id)
}