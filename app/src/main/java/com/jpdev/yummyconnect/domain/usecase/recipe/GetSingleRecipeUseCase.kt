package com.jpdev.yummyconnect.domain.usecase.recipe

import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class GetSingleRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend operator fun invoke(id: String) = recipeRepository.getRecipeById(id)
}