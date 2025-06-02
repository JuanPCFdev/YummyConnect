package com.jpdev.yummyconnect.domain.usecase.recipe

import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipesByUserUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend operator fun invoke(userId: String) = recipeRepository.getRecipesByUserId(userId)
}